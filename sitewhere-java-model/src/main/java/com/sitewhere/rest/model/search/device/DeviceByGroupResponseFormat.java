/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.spi.search.device.IDeviceByGroupResponseFormat;

/**
 * Default implementation of {@link IDeviceByGroupResponseFormat}.
 *
 * @author Jorge Villaverde
 */
public class DeviceByGroupResponseFormat extends DeviceResponseFormat implements IDeviceByGroupResponseFormat {

    /** Indicates if deletes devices are to be included in the result */
    private Boolean includeDeleted;

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceByGroupResponseFormat#getIncludeDeleted()
     */
    @Override
    public Boolean getIncludeDeleted() {
	return includeDeleted;
    }

    public void setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
    }

}
