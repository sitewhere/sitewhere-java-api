/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

import java.util.List;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria available for filtering device assignment search results.
 * 
 * @author Derek
 */
public interface IDeviceAssignmentSearchCriteria extends ISearchCriteria {

    /**
     * Limits search the given list of areas tokens.
     * 
     * @return
     */
    public List<String> getAreaTokens();
    
    /**
     * Indicates if the area are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeArea();

    /**
     * Limits search the given list of asset tokens.
     * 
     * @return
     */
    public List<String> getAssetTokens();

    /**
     * Indicates if the asset are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeAsset();

    /**
     * Limits search the given list of customer tokens.
     * 
     * @return
     */
    public List<String> getCustomerTokens();

    /**
     * Indicates if the customer are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeCustomer();
    
    /**
     * Limits search the given list of device tokens.
     * 
     * @return
     */
    public List<String> getDeviceTokens();

    /**
     * Indicates if the device are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeDevice();
    
}