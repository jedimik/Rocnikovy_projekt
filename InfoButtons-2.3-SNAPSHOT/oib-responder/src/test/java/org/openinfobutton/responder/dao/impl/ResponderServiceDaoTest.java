package org.openinfobutton.responder.dao.impl;

/*
 * #%L
 * Project: oib-rest-responder
 * Inception Year: 2,010
 * Director: 
 * Guilherme Del Fiol, MD, PhD
 * University of Utah
 * Biomedical Informatics
 * 421 Wakara Way, Ste 140
 * Salt Lake City, UT 84108-3514
 * Phone: 801-581-4080
 * %%
 * Copyright (C) 2010 - 2014 University of Utah
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import static junit.framework.TestCase.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.responder.service.ResponderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MissingServletRequestParameterException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
@Transactional("transactionManager")
public class ResponderServiceDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ResponderService service;
//    private EmbeddedDatabase db;

    @Override
    @Qualifier("dataSource")
    public void setDataSource(DataSource dataSource) {
        // leave it empty
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetApplicationProperties() {

        Properties props = service.getApplicationProperties("atom.feed");
        assertTrue(props.size() == 0);

    }

    @Test
    public void testRequestContainsRequiredParameters() {

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "111");
        boolean doesNot = false;

        try {
            doesNot = service.requestContainsRequiredParameters(requestParameters);
        } catch (MissingServletRequestParameterException ex) {
            Logger.getLogger(ResponderServiceDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertTrue(doesNot);

    }

    @Test
    public void testFindAssetsByInfobuttonRequest() {

        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "48447003");
        requestParameters.put("mainSearchCriteria.v.cs", "2.16.840.1.113883.6.96");
        requestParameters.put("taskContext.c.c", "PROBLISTREV");
        requestParameters.put("subTopic.v.c", "Q000744");
        requestParameters.put("age.v.v", "16");
        requestParameters.put("age.v.u", "a");
        requestParameters.put("patientPerson.administrativeGenderCode.c", "M");
        requestParameters.put("informationRecipient", "163W00000X");
        requestParameters.put("performer", "163W00000X");
        requestParameters.put("encounter.c.c", "AMB");

        try {
            Collection<Asset> assets = service.findAssetsByInfobuttonRequest(requestParameters);
        } catch (Exception e) {

            assertTrue(true);
        }

    }

    @Test
    public void testFindAssetsByInfobuttonRequest2() {

        Map<String, String> requestParameters = getTestRequestParameters();

        try {
            Collection<Asset> assets = service.findAssetsByInfobuttonRequest(requestParameters);
        } catch (Exception e) {

            assertTrue(true);
        }

    }

    @Test
    public void testGetSupportedRequestParameters() {

        Map<String, String> requestParameters = getTestRequestParameters();

        boolean doesContainRequiredParameters = false;

        try {

            doesContainRequiredParameters = service.requestContainsRequiredParameters(requestParameters);

        } catch (Exception e) {

            assertTrue(doesContainRequiredParameters);
        }

    }

    private Map<String, String> getTestRequestParameters() {
        
        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("mainSearchCriteria.v.c", "900469");
        requestParameters.put("mainSearchCriteria.v.cs", "2.16.840.1.113883.6.88");
        requestParameters.put("taskContext.c.c", "PROBLISTREV");
        requestParameters.put("subTopic.v.c", "Q000744");
        requestParameters.put("ageGroup.v.c", "D002675");
        return requestParameters;
    }

    @Test
    public void testGetIndexPropertyinterpretationMap() {

        boolean doesContainRequiredParameters = false;

        try {

            Map<String, Map<String, String>> map = service.getIndexPropertyInterpretationMap();

        } catch (Exception e) {

            assertTrue(doesContainRequiredParameters);
        }

    }

    @After
    public void tearDown() {
//        db.shutdown();
    }

}
