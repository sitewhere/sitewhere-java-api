/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.device.IDeviceGroupElementSearchCriteria;

/**
 * Default implementation of {@link IDeviceGroupElementSearchCriteria}.
 */
public class DeviceGroupElementSearchCriteria extends SearchCriteria implements IDeviceGroupElementSearchCriteria {

    /** Filter by group token */
    private String groupToken;

    /**
     * @param pageNumber
     * @param pageSize
     */
    public DeviceGroupElementSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    @Override
    public String getGroupToken() {
	return groupToken;
    }

    public void setGroupToken(String groupToken) {
	this.groupToken = groupToken;
    }
}
