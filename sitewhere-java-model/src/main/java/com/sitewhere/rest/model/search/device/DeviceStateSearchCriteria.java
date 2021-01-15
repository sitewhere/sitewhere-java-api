/**
 * Copyright © 2014-2020 The SiteWhere Authors
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
import java.util.List;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.device.IDeviceStateSearchCriteria;

/**
 * Provides filter criteria for device state searches.
 */
public class DeviceStateSearchCriteria extends SearchCriteria implements IDeviceStateSearchCriteria {

    /** Filter by last interaction date before a given value */
    private Date lastInteractionDateBefore;

    /** Device tokens to be included */
    private List<String> deviceTokens;

    /** Device assignment tokens to be included */
    private List<String> deviceAssignmentTokens;

    /** Device type tokens to be included */
    private List<String> deviceTypeTokens;

    /** Customer tokens to be included */
    private List<String> customerTokens;

    /** Area tokens to be included */
    private List<String> areaTokens;

    /** Asset tokens to be included */
    private List<String> assetTokens;

    public DeviceStateSearchCriteria() {
	super();
    }

    public DeviceStateSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#
     * getDeviceAssignmentTokens()
     */
    @Override
    public List<String> getDeviceAssignmentTokens() {
	return deviceAssignmentTokens;
    }

    public void setDeviceAssignmentTokens(List<String> deviceAssignmentTokens) {
	this.deviceAssignmentTokens = deviceAssignmentTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#
     * getDeviceTypeTokens()
     */
    @Override
    public List<String> getDeviceTypeTokens() {
	return deviceTypeTokens;
    }

    public void setDeviceTypeTokens(List<String> deviceTypeTokens) {
	this.deviceTypeTokens = deviceTypeTokens;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#getCustomerTokens(
     * )
     */
    @Override
    public List<String> getCustomerTokens() {
	return customerTokens;
    }

    public void setCustomerTokens(List<String> customerTokens) {
	this.customerTokens = customerTokens;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#getAreaTokens()
     */
    @Override
    public List<String> getAreaTokens() {
	return areaTokens;
    }

    public void setAreaTokens(List<String> areaTokens) {
	this.areaTokens = areaTokens;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#getAssetTokens()
     */
    @Override
    public List<String> getAssetTokens() {
	return assetTokens;
    }

    public void setAssetTokens(List<String> assetTokens) {
	this.assetTokens = assetTokens;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateSearchCriteria#
     * getLastInteractionDateBefore()
     */
    @Override
    public Date getLastInteractionDateBefore() {
	return lastInteractionDateBefore;
    }

    public void setLastInteractionDateBefore(Date lastInteractionDateBefore) {
	this.lastInteractionDateBefore = lastInteractionDateBefore;
    }
}