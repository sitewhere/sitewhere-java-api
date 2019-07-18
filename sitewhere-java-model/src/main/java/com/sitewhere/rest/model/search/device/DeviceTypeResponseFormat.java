/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.spi.search.device.IDeviceTypeResponseFormat;

/**
 * Default implementation of {@link IDeviceTypeResponseFormat}.
 */
public class DeviceTypeResponseFormat implements IDeviceTypeResponseFormat {

    /** Indicates if asset is included */
    private Boolean includeAsset;

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceTypeResponseFormat#getIncludeAsset()
     */
    @Override
    public Boolean getIncludeAsset() {
	return includeAsset;
    }

    public void setIncludeAsset(Boolean includeAsset) {
	this.includeAsset = includeAsset;
    }

}
