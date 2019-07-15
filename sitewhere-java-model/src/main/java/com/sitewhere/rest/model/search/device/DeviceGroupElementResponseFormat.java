/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.spi.search.device.IDeviceGroupElementResponseFormat;

/**
 * Default implementation of {@link IDeviceGroupElementResponseFormat}.
 *
 * @author Jorge Villaverde
 */
public class DeviceGroupElementResponseFormat implements IDeviceGroupElementResponseFormat {
    
    /** Details are to be included in the result */
    private Boolean includeDetails;

    /*
     * @see com.sitewhere.rest.model.search.device.DeviceGroupElementResponseFormat.
     * getIncludeDetails()#getIncludeDetails( )
     */
    @Override
    public Boolean getIncludeDetails() {
	return includeDetails;
    }

    public void setIncludeDetails(Boolean includeDetails) {
	this.includeDetails = includeDetails;
    }

}
