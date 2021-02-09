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

import java.util.List;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria;

/**
 * Default implementation of {@link IDeviceAssignmentSearchCriteria}.
 */
public class DeviceAssignmentSearchCriteria extends SearchCriteria implements IDeviceAssignmentSearchCriteria {

    /** Filter by area tokens */
    private List<DeviceAssignmentStatus> assignmentStatuses;

    /** Filter by area tokens */
    private List<String> areaTokens;

    /** Filter by asset tokens */
    private List<String> assetTokens;

    /** Filter by customer tokens */
    private List<String> customerTokens;

    /** Filter by device tokens */
    private List<String> deviceTokens;

    /** Filter by device type tokens */
    private List<String> deviceTypeTokens;

    public DeviceAssignmentSearchCriteria() {
    }

    public DeviceAssignmentSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#
     * getAssignmentStatuses()
     */
    @Override
    public List<DeviceAssignmentStatus> getAssignmentStatuses() {
	return assignmentStatuses;
    }

    public void setAssignmentStatuses(List<DeviceAssignmentStatus> assignmentStatuses) {
	this.assignmentStatuses = assignmentStatuses;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getAreaTokens
     * ()
     */
    @Override
    public List<String> getAreaTokens() {
	return areaTokens;
    }

    public void setAreaTokens(List<String> areaTokens) {
	this.areaTokens = areaTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#
     * getAssetTokens()
     */
    @Override
    public List<String> getAssetTokens() {
	return assetTokens;
    }

    public void setAssetTokens(List<String> assetTokens) {
	this.assetTokens = assetTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#
     * getCustomerTokens()
     */
    @Override
    public List<String> getCustomerTokens() {
	return customerTokens;
    }

    public void setCustomerTokens(List<String> customerTokens) {
	this.customerTokens = customerTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#
     * getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#
     * getDeviceTypeTokens()
     */
    @Override
    public List<String> getDeviceTypeTokens() {
	return deviceTypeTokens;
    }

    public void setDeviceTypeTokens(List<String> deviceTypeTokens) {
	this.deviceTypeTokens = deviceTypeTokens;
    }
}