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
package com.sitewhere.rest.model.asset.marshaling;

import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetType;

/**
 * Extends {@link Asset} to support fields that can be included on REST calls.
 */
public class MarshaledAsset extends Asset {

    /** Serial version UID */
    private static final long serialVersionUID = 6394550253455081960L;

    /** Asset type */
    private AssetType assetType;

    public AssetType getAssetType() {
	return assetType;
    }

    public void setAssetType(AssetType assetType) {
	this.assetType = assetType;
    }
}