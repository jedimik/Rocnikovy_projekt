package org.openinfobutton.service.dao.impl;

/*
 * #%L
 * Project:  oib-app-service
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
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.openinfobutton.app.dao.DaoBase;
import org.openinfobutton.app.model.Asset;
import org.openinfobutton.app.model.AssetProperty;
import org.openinfobutton.service.dao.ServiceAssetDao;
import org.springframework.stereotype.Repository;

/**
 * The Class ServiceAssetDaoImpl.
 *
 * @author rick
 */
@Repository
public class ServiceAssetDaoImpl
        extends DaoBase<Asset>
        implements ServiceAssetDao {

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#addAssetProperty(org.openinfobutton.app.model.AssetProperty)
     */
    @Override
    public void addAssetProperty(AssetProperty assetProperty) {
        getSessionFactory().getCurrentSession().save(assetProperty);
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#findAssetsByPropertyCodeSystem(java.lang.String)
     */
    @Override
    public List<Asset> findAssetsByPropertyCodeSystem(String codeSystem) {
        final String hql = "select distinct ap.asset from AssetProperty ap where ap.codeSystem = :codeSystem";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("codeSystem", codeSystem);
        return query.list();
    }

    /**
     * Find asset properties by generated code.
     *
     * @param generatedByCodes the generated by codes
     * @return the list
     */
    public List<AssetProperty> findAssetPropertiesByGeneratedCode(Set<String> generatedByCodes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#findMaxAssetPropertyGroup(java.math.BigDecimal)
     */
    @Override
    public int findMaxAssetPropertyGroup(BigDecimal assetId) {

        final String hql
                = "select max(ap.propertyGroupNumber) as maxValue from AssetProperty ap where ap.asset.assetId = :assetId ";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        final BigInteger maxPropertyGroupNumber = (BigInteger) query.iterate().next();

        return maxPropertyGroupNumber.intValue();
    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#deleteAllAssetPropertiesByGeneratedByCode(java.utils.Set)
     */
    @Override
    public void deleteAllAssetPropertiesByGeneratedByCode(Set<String> generatedByCodes) {

        final String hql
                = "delete from AssetProperty ap where ap.assetId=:assetId and ap.generatedByCode in (:generatedByCodes)";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("generatedByCodes", generatedByCodes);
        query.executeUpdate();

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteAllAssetPropertiesByGeneratedByCodeAndCodeSystem(String codeSystem, String generatedByCode) {

        final String hql
                = "delete from AssetProperty ap where ap.asset.assetId=:assetId and "
                + "ap.codeSystem=:codeSystem and ap.generatedByCode=:generatedByCode";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("codeSystem", codeSystem);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#deleteAssetPropertiesByGeneratedByCode(java.math.BigDecimal, java.lang.String)
     */
    @Override
    public void deleteAssetPropertiesByGeneratedByCode(BigDecimal assetId, String generatedByCode) {

        final String hql
                = "delete from AssetProperty ap where ap.asset.assetId=:assetId and ap.generatedByCode=:generatedByCode";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

    /*
     * (non-Javadoc)
     * @see org.openinfobutton.service.dao.ServiceAssetDao#deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(java.math.BigDecimal, java.lang.String, java.lang.String)
     */
    @Override
    public void deleteAssetPropertiesByGeneratedByCodeAndCodeSystem(BigDecimal assetId, String codeSystem,
            String generatedByCode) {

        final String hql
                = "delete from AssetProperty ap where ap.asset.assetId=:assetId and ap.codeSystem=:codeSystem "
                + "and ap.generatedByCode=:generatedByCode";
        final Query query = getSessionFactory().getCurrentSession().createQuery(hql.toString());
        query.setParameter("assetId", assetId);
        query.setParameter("codeSystem", codeSystem);
        query.setParameter("generatedByCode", generatedByCode);
        query.executeUpdate();

    }

}