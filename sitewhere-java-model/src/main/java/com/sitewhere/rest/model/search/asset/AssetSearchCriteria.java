/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.rest.model.search.asset;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.asset.IAssetSearchCriteria;

/**
 * Model object for properties used in asset searches.
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
     * @see
     * com.sitewhere.spi.search.asset.IAssetSearchCriteria#getIncludeAssetType()
     */
    @Override
    public Boolean getIncludeAssetType() {
	return includeAssetType;
    }

    public void setIncludeAssetType(Boolean includeAssetType) {
	this.includeAssetType = includeAssetType;
    }
}