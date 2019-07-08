/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.device.DeviceAssignmentStatus;

/**
 * Search criteria for device assignments.
 * 
 * @author Jorge Villaverde
 */
public class DeviceAssignmentForAreaSearchCriteria extends SearchCriteria {
    
    /** Limit results to the given status */
    private DeviceAssignmentStatus status;
    
    /** Indicates if device are to be returned */
    private Boolean includeDevice = false;
    
    /** Indicates is customer are to be returned */
    private Boolean includeCustomer = false;
    
    /** Indicates if area are to be returned */
    private Boolean includeArea = false;
    
    /** Indicates if asset are to be returned */
    private Boolean includeAsset = false;
    
    public DeviceAssignmentForAreaSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    public DeviceAssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceAssignmentStatus status) {
        this.status = status;
    }

    public Boolean getIncludeDevice() {
        return includeDevice;
    }

    public void setIncludeDevice(Boolean includeDevice) {
        this.includeDevice = includeDevice;
    }

    public Boolean getIncludeCustomer() {
        return includeCustomer;
    }

    public void setIncludeCustomer(Boolean includeCustomer) {
        this.includeCustomer = includeCustomer;
    }

    public Boolean getIncludeArea() {
        return includeArea;
    }

    public void setIncludeArea(Boolean includeArea) {
        this.includeArea = includeArea;
    }

    public Boolean getIncludeAsset() {
        return includeAsset;
    }

    public void setIncludeAsset(Boolean includeAsset) {
        this.includeAsset = includeAsset;
    }

}
