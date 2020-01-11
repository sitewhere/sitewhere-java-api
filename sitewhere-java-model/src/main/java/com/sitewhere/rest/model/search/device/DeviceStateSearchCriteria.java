/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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