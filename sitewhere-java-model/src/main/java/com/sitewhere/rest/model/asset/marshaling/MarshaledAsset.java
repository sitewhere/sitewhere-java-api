/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.asset.marshaling;

import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.asset.AssetType;

/**
 * Extends {@link Asset} to support fields that can be included on REST calls.
 * 
 * @author Derek
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