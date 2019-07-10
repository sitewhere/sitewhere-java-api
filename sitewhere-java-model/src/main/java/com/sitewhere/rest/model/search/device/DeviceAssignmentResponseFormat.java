/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
