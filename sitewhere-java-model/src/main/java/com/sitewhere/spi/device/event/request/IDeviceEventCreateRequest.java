/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.request;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.device.event.DeviceEventType;

/**
 * Interface for arguments needed to create a device event.
 */
public interface IDeviceEventCreateRequest extends Serializable {

    /**
     * Get alternate id that can be used for correlating events with external
     * systems and for deduplication.
     * 
     * @return
     */
    String getAlternateId();

    /**
     * Get event type indicator.
     * 
     * @return
     */
    DeviceEventType getEventType();

    /**
     * Get the date on which the event occurred.
     * 
     * @return
     */
    Date getEventDate();

    /**
     * Indicates whether state information on the device assignment should be
     * updated to reflect new event.
     * 
     * @return
     */
    boolean isUpdateState();

    /**
     * Get metadata values.
     * 
     * @return
     */
    Map<String, String> getMetadata();
}