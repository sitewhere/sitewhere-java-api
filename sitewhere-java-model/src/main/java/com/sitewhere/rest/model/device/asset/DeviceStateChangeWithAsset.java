/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.asset;

import com.sitewhere.rest.model.device.event.DeviceStateChange;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;

/**
 * Model object for device state change with asset.
 */
public class DeviceStateChangeWithAsset extends DeviceStateChange implements IDeviceEventWithAsset {

    /** Serialization version identifier */
    private static final long serialVersionUID = -7240669600220337960L;

    /** Name of the asset */
    private String assetName;

    /*
     * @see
     * com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset.getAssetName()#
     * getAssetName()
     */
    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }
}
