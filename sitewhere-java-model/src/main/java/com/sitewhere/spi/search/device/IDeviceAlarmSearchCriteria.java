/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

import java.util.UUID;

import com.sitewhere.spi.device.DeviceAlarmState;
import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria used to search for device alarms.
 */
public interface IDeviceAlarmSearchCriteria extends ISearchCriteria {

    /**
     * Get device id.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get assignment id.
     * 
     * @return
     */
    UUID getDeviceAssignmentId();

    /**
     * Get customer id if assigned.
     * 
     * @return
     */
    UUID getCustomerId();

    /**
     * Get area id if assigned.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get asset id if assigned.
     * 
     * @return
     */
    UUID getAssetId();

    /**
     * Get event id that triggered alarm.
     * 
     * @return
     */
    UUID getTriggeringEventId();

    /**
     * Get alarm state.
     * 
     * @return
     */
    DeviceAlarmState getState();
}