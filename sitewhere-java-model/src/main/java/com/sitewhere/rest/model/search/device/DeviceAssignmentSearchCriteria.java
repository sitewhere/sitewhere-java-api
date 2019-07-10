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
import com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria;

/**
 * Default implementation of {@link IDeviceAssignmentSearchCriteria}.
 * 
 * @author Derek
 */
public class DeviceAssignmentSearchCriteria extends SearchCriteria implements IDeviceAssignmentSearchCriteria {

    /** Filter by area tokens */ 
    private List<String> areaTokens;
    
    /** Indicates if area are to be included */
    private Boolean includeArea;
    
    /** Filter by asset tokens */
    private List<String> assetTokens;
    
    /** Indicates of asset are to be included */
    private Boolean includeAsset;
    
    /** Filter by customer tokens */
    private List<String> customerTokens;
    
    /** Indicates if customer are to be included */
    private Boolean includeCustomer;
    
    /** Filter by device tokens */
    private List<String> deviceTokens;
    
    /** Indicates if device are to be included */
    private Boolean includeDevice;

    public DeviceAssignmentSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }
    
    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getAreaTokens()
     */
    @Override
    public List<String> getAreaTokens() {
	return this.areaTokens;
    }

    public void setAreaTokens(List<String> areaTokens) {
        this.areaTokens = areaTokens;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getIncludeArea()
     */
    @Override
    public Boolean getIncludeArea() {
	return this.includeArea;
    }

    public void setIncludeArea(Boolean includeArea) {
        this.includeArea = includeArea;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getAssetTokens()
     */
    @Override
    public List<String> getAssetTokens() {
	return this.assetTokens;
    }

    public void setAssetTokens(List<String> assetTokens) {
        this.assetTokens = assetTokens;
    }
    
    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getIncludeAsset()
     */
    @Override
    public Boolean getIncludeAsset() {
	return this.includeAsset;
    }

    public void setIncludeAsset(Boolean includeAsset) {
        this.includeAsset = includeAsset;
    }
    
    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getCustomerTokens()
     */
    @Override
    public List<String> getCustomerTokens() {
	return this.customerTokens;
    }

    public void setCustomerTokens(List<String> customerTokens) {
        this.customerTokens = customerTokens;
    }
    
    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getIncludeCustomer()
     */
    @Override
    public Boolean getIncludeCustomer() {
	return this.includeCustomer;
    }

    public void setIncludeCustomer(Boolean includeCustomer) {
        this.includeCustomer = includeCustomer;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return this.deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
        this.deviceTokens = deviceTokens;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceAssignmentSearchCriteria#getIncludeDevice()
     */
    @Override
    public Boolean getIncludeDevice() {
	return this.includeDevice;
    }

    public void setIncludeDevice(Boolean includeDevice) {
        this.includeDevice = includeDevice;
    }
}