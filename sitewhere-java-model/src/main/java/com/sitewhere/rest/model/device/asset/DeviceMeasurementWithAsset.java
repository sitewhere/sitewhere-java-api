/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.asset;

import com.sitewhere.rest.model.device.event.DeviceMeasurement;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;

/**
 * Model object for device measurement with asset.
 */
public class DeviceMeasurementWithAsset extends DeviceMeasurement implements IDeviceEventWithAsset {

    /** Serialization version identifier */
    private static final long serialVersionUID = 2505526959429621669L;

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
