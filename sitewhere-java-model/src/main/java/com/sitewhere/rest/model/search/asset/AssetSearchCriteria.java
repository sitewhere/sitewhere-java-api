/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.asset;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.asset.IAssetSearchCriteria;

/**
 * Model object for properties used in asset searches.
 * 
 * @author Derek
 */
public class AssetSearchCriteria extends SearchCriteria implements IAssetSearchCriteria {
    
    /** Filter by asset type */
    private String assetTypeToken;
    
    /** Include asset type */
    private Boolean includeAssetType;

    public AssetSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.asset.IAssetSearchCriteria#getAssetTypeToken()
     */
    @Override
    public String getAssetTypeToken() {
        return assetTypeToken;
    }

    public void setAssetTypeToken(String assetTypeToken) {
        this.assetTypeToken = assetTypeToken;
    }

    /*
     * @see com.sitewhere.spi.search.asset.IAssetSearchCriteria#getIncludeAssetType()
     */
    @Override
    public Boolean getIncludeAssetType() {
        return includeAssetType;
    }

    public void setIncludeAssetType(Boolean includeAssetType) {
        this.includeAssetType = includeAssetType;
    }
}