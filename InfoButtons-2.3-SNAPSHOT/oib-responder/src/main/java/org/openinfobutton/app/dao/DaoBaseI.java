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

import java.io.Serializable;

/**
 * The Interface DaoBaseI.
 *
 * @author Rick Bradshaw Base interface for basic DAO operations Generic Dao
 * pattern
 * @param <T> the generic type
 */
public interface DaoBaseI<T> {

    /**
     * Save.
     *
     * @param domain the domain
     */
    public void save(T domain);

    /**
     * Update.
     *
     * @param domain the domain
     */
    public void update(T domain);

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Serializable id);

    /**
     * Gets the.
     *
     * @param id the id
     * @return the t
     */
    public T get(Serializable id);

}
