/**
 * Copyright © 2014-2021 The SiteWhere Authors
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
package com.sitewhere.rest.model.asset;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.spi.asset.IAsset;

/**
 * Model object for an asset.
 */
@JsonInclude(Include.NON_NULL)
public class Asset extends BrandedEntity implements IAsset {

    /** Serial version UID */
    private static final long serialVersionUID = -853673101089583873L;

    /** Asset type id */
    private UUID assetTypeId;

    /** Asset name */
    private String name;

    /*
     * @see com.sitewhere.spi.asset.IAsset#getAssetTypeId()
     */
    @Override
    public UUID getAssetTypeId() {
	return assetTypeId;
    }

    public void setAssetTypeId(UUID assetTypeId) {
	this.assetTypeId = assetTypeId;
    }

    /*
     * @see com.sitewhere.spi.asset.IAsset#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}