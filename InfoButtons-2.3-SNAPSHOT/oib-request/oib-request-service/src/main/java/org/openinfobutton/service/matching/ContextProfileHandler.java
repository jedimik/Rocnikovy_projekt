/**
 * -----------------------------------------------------------------------------------
 * (c) 2010-2014 OpenInfobutton Project, Biomedical Informatics, University of Utah
 * Contact: {@code <andrew.iskander@utah.edu>}
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Day Phone: 1-801-581-4080
 * -----------------------------------------------------------------------------------
 *
 * @author Andrew Iskander {@code <andrew.iskander@utah.edu>}
 * @version Jul 15, 2014
 */
package org.openinfobutton.service.matching;

import java.util.List;
import java.util.Map;

import org.openinfobutton.externalresource.api.ExternalResourceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openinfobutton.exception.OIBProfileProcessingException;
import org.openinfobutton.schema.KnowledgeRequest;
import org.openinfobutton.schemas.kb.Code;
import org.openinfobutton.schemas.kb.Context;
import org.openinfobutton.schemas.kb.KnowledgeResourceProfile;
import org.openinfobutton.schemas.kb.ProfileDefinition.AuthorizedOrganizations.AuthorizedOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextProfileHandler.
 */
@Service
public class ContextProfileHandler
{

    /** The log. */
    Logger log = LogManager.getLogger( ContextProfileHandler.class.getName() );

    /** The matcher. */
    ContextMatcher matcher;

    @Autowired
    ExternalResourceHandler handler;

    /**
     * Handle request.
     *
     * @param r the r
     * @return the list
     */
    public void handleRequest( KnowledgeRequest request , final List<RequestResult> results, Map<Long, KnowledgeResourceProfile> profiles)
    {
        final org.apache.logging.log4j.Logger logger = LogManager.getLogger(ContextProfileHandler.class);
        logger.error("THIS IS WHERE THE CODE IS: " + request.getMainSearchCriteria().getCode().getCode());

        Code code = request.getMainSearchCriteria().getCode();
        if (code.getCode().equals("")) {
            logger.error("Starting Free Text Transformation for code: " + code.getDisplayName());
            request.setSearchCodes(handler.transformFreeText(code.getDisplayName()));
            logger.error("Free Text Transformation Complete: " + request.getSearchCodes());
        }

        for (  Map.Entry<Long, KnowledgeResourceProfile> profile : profiles.entrySet()  )
        {
            try {
                results.add(matchContexts(profile.getValue(), request));
            }
            catch (RuntimeException e)
            {
                log.debug("\t\tProfile Processing Error While Matching Caused By: " + profile.getValue().getHeader().getTitle());
                throw new OIBProfileProcessingException("Matching Error Caused By Configuration Problem In: " + profile.getValue().getHeader().getTitle(), e);
            }

        }
    }

    /**
     * The contexts in a profile are matched against the request.If successful the context is added to the result.
     *
     * @param profile the profile
     * @return RequestResult
     */
    private RequestResult matchContexts( KnowledgeResourceProfile profile, KnowledgeRequest request )
    {
            log.debug("Matching profile... " + profile.getHeader().getTitle());
            final RequestResult result = new RequestResult(profile);
            final List<String> supportedCodeSystems = result.getSupportedCodeSystems();
            log.debug("    SupportedCS " + supportedCodeSystems);
            final List<Context> contexts = profile.getProfileDefinition().getContexts().getContext();
            final int count = contexts.size();
            setOrganizationSpecificParameters(request, result, profile.getProfileDefinition().getAuthorizedOrganizations().getAuthorizedOrganization());
            Context context;

            for (int x = 0; x < count; x++) {
                log.debug("\tMatching Context Started...");
                context = contexts.get(x);
                matcher = new TaskContextMatcher(context.getContextDefinition().getTask(), request, supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tTaskContextMatcher FAILED");
                    continue;
                }
                matcher =
                        new PerformerMatcher(context.getContextDefinition().getPerformerLanguage(),
                                context.getContextDefinition().getPerformerDiscipline(),
                                context.getContextDefinition().getPerformerKnowledgeUserType(), request,
                                supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tPerformerMatcher FAILED");
                    continue;
                }
                matcher =
                        new InformationRecipientMatcher(context.getContextDefinition().getInformationRecipientLanguage(),
                                context.getContextDefinition().getInformationRecipientDiscipline(),
                                context.getContextDefinition().getInformationRecipientUserType(),
                                request, supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tInformationRecipientMatcher FAILED");
                    continue;
                }
                matcher =
                        new EncounterMatcher(context.getContextDefinition().getEncounterType(),
                                context.getContextDefinition().getServiceDeliveryLocation(), request,
                                supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tEncounterMatcher FAILED");
                    continue;
                }
                matcher =
                        new PatientContextMatcher(context.getContextDefinition().getPatientGender(),
                                context.getContextDefinition().getPatientAgeGroup(), request,
                                supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tPatientContextMatcher FAILED");
                    continue;
                }
                matcher =
                        new MainSearchCriteriaMatcher(context.getContextDefinition().getConceptOfInterest(), request,
                                supportedCodeSystems);
                if (!matcher.MatchContext()) {
                    log.debug("\t\tMainSearchCriteriaMatcher FAILED");
                    continue;
                }
                log.debug("\t\tAdding Context to result...");
                result.addResult(context);
            }
            return result;
    }
    
    private void setOrganizationSpecificParameters(KnowledgeRequest request, final RequestResult result, List<AuthorizedOrganization> authorizedOrganizations)
    {
        result.setOrganizationURL( null );
        result.setUseAssignedAuthorizedPerson( false );
        for (AuthorizedOrganization org : authorizedOrganizations)
        {
            if (request.getHolder().getRepresentedOrganization().getRoot().equals( org.getId() ))
            {
                if (org.isUsesAssignedAuthorizedPerson() != null)
                {
                    result.setUseAssignedAuthorizedPerson( org.isUsesAssignedAuthorizedPerson() );
                }
                if (org.getKnowledgeRequestServiceLocation() != null)
                {
                    result.setOrganizationURL( org.getKnowledgeRequestServiceLocation().getUrl());
                }
            }
        }
    }
}
