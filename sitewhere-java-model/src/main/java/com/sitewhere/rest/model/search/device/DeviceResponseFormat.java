/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.spi.search.device.IDeviceResponseFormat;

/**
 * Default implementation of {@link IDeviceResponseFormat}.
 */
public class DeviceResponseFormat implements IDeviceResponseFormat {

    /** Indicates if device type is included */
    private Boolean includeDeviceType;

    /** Indicates if assignment is included */
    private Boolean includeAssignment;

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceResponseFormat#getIncludeDeviceType()
     */
    @Override
    public Boolean getIncludeDeviceType() {
	return includeDeviceType;
    }

    public void setIncludeDeviceType(Boolean includeDeviceType) {
	this.includeDeviceType = includeDeviceType;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceResponseFormat#getIncludeAssignment()
     */
    @Override
    public Boolean getIncludeAssignment() {
	return includeAssignment;
    }

}
