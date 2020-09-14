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

import com.sitewhere.spi.search.device.IDeviceStateResponseFormat;

/**
 * Default implementation of {@link IDeviceStateResponseFormat}.
 */
public class DeviceStateResponseFormat implements IDeviceStateResponseFormat {

    /** Indicates if area is included */
    private Boolean includeArea;

    /** Indicates if asset is included */
    private Boolean includeAsset;

    /** Indicates if customer is included */
    private Boolean includeCustomer;

    /** Indicates if device is included */
    private Boolean includeDevice;

    /** Indicate if device assignment is included */
    private Boolean includeDeviceAssignment;

    /** Indicates if device type is included */
    private Boolean includeDeviceType;

    /** Indicates if event details is included */
    private Boolean includeEventDetails;

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateResponseFormat#getIncludeArea()
     */
    @Override
    public Boolean getIncludeArea() {
	return includeArea;
    }

    public void setIncludeArea(Boolean includeArea) {
	this.includeArea = includeArea;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateResponseFormat#getIncludeAsset()
     */
    @Override
    public Boolean getIncludeAsset() {
	return includeAsset;
    }

    public void setIncludeAsset(Boolean includeAsset) {
	this.includeAsset = includeAsset;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateResponseFormat#getIncludeCustomer
     * ()
     */
    @Override
    public Boolean getIncludeCustomer() {
	return includeCustomer;
    }

    public void setIncludeCustomer(Boolean includeCustomer) {
	this.includeCustomer = includeCustomer;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceStateResponseFormat#getIncludeDevice()
     */
    @Override
    public Boolean getIncludeDevice() {
	return includeDevice;
    }

    public void setIncludeDevice(Boolean includeDevice) {
	this.includeDevice = includeDevice;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateResponseFormat#
     * getIncludeDeviceAssignment()
     */
    @Override
    public Boolean getIncludeDeviceAssignment() {
	return includeDeviceAssignment;
    }

    public void setIncludeDeviceAssignment(Boolean includeDeviceAssignment) {
	this.includeDeviceAssignment = includeDeviceAssignment;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateResponseFormat#
     * getIncludeDeviceType()
     */
    @Override
    public Boolean getIncludeDeviceType() {
	return includeDeviceType;
    }

    public void setIncludeDeviceType(Boolean includeDeviceType) {
	this.includeDeviceType = includeDeviceType;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceStateResponseFormat#
     * getIncludeEventDetails()
     */
    @Override
    public Boolean getIncludeEventDetails() {
	return includeEventDetails;
    }

    public void setIncludeEventDetails(Boolean includeEventDetails) {
	this.includeEventDetails = includeEventDetails;
    }

}
