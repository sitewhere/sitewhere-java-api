/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

import java.util.UUID;

import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria used for filtering recent state events.
 */
public interface IRecentStateEventSearchCriteria extends ISearchCriteria {

    /**
     * Get id of device state entity.
     * 
     * @return
     */
    UUID getDeviceStateId();

    /**
     * Get type of event.
     * 
     * @return
     */
    DeviceEventType getEventType();

    /**
     * Uniquely classifies an event within a type (e.g. mx name or alert type).
     * 
     * @return
     */
    String getClassifier();
}
