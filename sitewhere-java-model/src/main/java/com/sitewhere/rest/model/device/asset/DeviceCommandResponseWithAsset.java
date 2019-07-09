/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.asset;

import com.sitewhere.rest.model.device.event.DeviceCommandResponse;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;

/**
 * Model object for device command response with asset.
 * 
 * @author Jorge Villaverde
 */
public class DeviceCommandResponseWithAsset extends DeviceCommandResponse implements IDeviceEventWithAsset {

    /** Serial version UID */
    private static final long serialVersionUID = -1832990253778845202L;

    /** asset name */
    private String assetName;
    
    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.asset.IDeviceEventWithAsset#getAssetName()
     */
    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    
}
