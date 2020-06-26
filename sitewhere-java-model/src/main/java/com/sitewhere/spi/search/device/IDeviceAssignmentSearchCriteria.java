/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

import java.util.List;

import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria available for filtering device assignment search results.
 */
public interface IDeviceAssignmentSearchCriteria extends ISearchCriteria {

    /**
     * Limits search the given list of device assignment statuses.
     * 
     * @return
     */
    List<DeviceAssignmentStatus> getAssignmentStatuses();

    /**
     * Limits search the given list of areas tokens.
     * 
     * @return
     */
    List<String> getAreaTokens();

    /**
     * Limits search the given list of asset tokens.
     * 
     * @return
     */
    List<String> getAssetTokens();

    /**
     * Limits search the given list of customer tokens.
     * 
     * @return
     */
    List<String> getCustomerTokens();

    /**
     * Limits search the given list of device tokens.
     * 
     * @return
     */
    List<String> getDeviceTokens();

    /**
     * Limits search the given list of device type tokens.
     * 
     * @return
     */
    List<String> getDeviceTypeTokens();
}