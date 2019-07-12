/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import java.util.List;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria;

/**
 * Default implementation of {@link IDeviceAssignmentSearchCriteria}.
 * 
 * @author Derek
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