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

import com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat;

/**
 * Determines which content is returned for device assignment responses.
 */
public class DeviceAssignmentResponseFormat implements IDeviceAssignmentResponseFormat {

    /** Include area detail */
    private Boolean includeArea;

    /** Include asset detail */
    private Boolean includeAsset;

    /** Include customer detail */
    private Boolean includeCustomer;

    /** Include device detail */
    private Boolean includeDevice;

    /** Include device type detail */
    private Boolean includeDeviceType;

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat#
     * getIncludeArea()
     */
    @Override
    public Boolean getIncludeArea() {
	return includeArea;
    }

    public void setIncludeArea(Boolean includeArea) {
	this.includeArea = includeArea;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat#
     * getIncludeAsset()
     */
    @Override
    public Boolean getIncludeAsset() {
	return includeAsset;
    }

    public void setIncludeAsset(Boolean includeAsset) {
	this.includeAsset = includeAsset;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat#
     * getIncludeCustomer()
     */
    @Override
    public Boolean getIncludeCustomer() {
	return includeCustomer;
    }

    public void setIncludeCustomer(Boolean includeCustomer) {
	this.includeCustomer = includeCustomer;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat#
     * getIncludeDevice()
     */
    @Override
    public Boolean getIncludeDevice() {
	return includeDevice;
    }

    public void setIncludeDevice(Boolean includeDevice) {
	this.includeDevice = includeDevice;
    }

    /*
     * @see com.sitewhere.spi.search.device.IDeviceAssignmentResponseFormat#
     * getIncludeDeviceType()
     */
    @Override
    public Boolean getIncludeDeviceType() {
	return includeDeviceType;
    }

    public void setIncludeDeviceType(Boolean includeDeviceType) {
	this.includeDeviceType = includeDeviceType;
    }
}
