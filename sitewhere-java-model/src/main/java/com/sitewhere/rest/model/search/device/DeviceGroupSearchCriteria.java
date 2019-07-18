/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.device.IDeviceGroupSearchCriteria;

/**
 * Default implementation of {@link IDeviceGroupSearchCriteria}.
 */
public class DeviceGroupSearchCriteria extends SearchCriteria implements IDeviceGroupSearchCriteria {

    /** Filter by role */
    private String role;

    /**
     * @param pageNumber
     * @param pageSize
     */
    public DeviceGroupSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    @Override
    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

}
