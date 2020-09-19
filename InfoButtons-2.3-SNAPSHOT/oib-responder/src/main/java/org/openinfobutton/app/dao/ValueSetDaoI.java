package org.openinfobutton.app.dao;

/*
 * #%L
 * Project:  oib-app-model
 * Director: Guilherme Del Fiol, MD, PhD
 *           University of Utah
 *           Biomedical Informatics
 *           421 Wakara Way, Suite 140
 *           Salt Lake City, UT 84108-3514
 * Phone:    801-581-4080
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

import java.math.BigDecimal;
import java.util.List;
import org.openinfobutton.app.model.ValueSet;
import org.openinfobutton.app.model.ValueSetCode;

// TODO: Auto-generated Javadoc
/**
 * The Interface ValueSetDaoI.
 *
 * @author rick
 */
public interface ValueSetDaoI
        extends DaoBaseI<ValueSet> {

    /**
     * Gets the value set codes.
     *
     * @param valueSetId the value set id
     * @return the value set codes
     */
    List<ValueSetCode> getValueSetCodes(BigDecimal valueSetId);

}
