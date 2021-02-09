/**
 * Copyright © 2014-2021 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.rest.model.search.device;

import java.util.Date;

import com.sitewhere.rest.model.search.DateRangeSearchCriteria;
import com.sitewhere.spi.search.device.IDeviceSearchCriteria;

/**
 * Adds options specific to device searches.
 */
public class DeviceSearchCriteria extends DateRangeSearchCriteria implements IDeviceSearchCriteria {

    /** Search criteria for getting all records */
    public static DeviceSearchCriteria ALL = new DeviceSearchCriteria(null, false, 1, 0, null, null);

    /** Device type to match in filter */
    private String deviceTypeToken;

    /** Indicates if assigned devices should be excluded */
    private boolean excludeAssigned = false;

    public DeviceSearchCriteria(int pageNumber, int pageSize, Date startDate, Date endDate) {
	super(pageNumber, pageSize, startDate, endDate);
    }

    public DeviceSearchCriteria(String deviceTypeToken, boolean excludeAssigned, int pageNumber, int pageSize,
	    Date startDate, Date endDate) {
	super(pageNumber, pageSize, startDate, endDate);
	this.deviceTypeToken = deviceTypeToken;
	this.excludeAssigned = excludeAssigned;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceSearchCriteria#getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.search.device.IDeviceSearchCriteria#isExcludeAssigned()
     */
    @Override
    public boolean isExcludeAssigned() {
	return excludeAssigned;
    }

    public void setExcludeAssigned(boolean excludeAssigned) {
	this.excludeAssigned = excludeAssigned;
    }
}