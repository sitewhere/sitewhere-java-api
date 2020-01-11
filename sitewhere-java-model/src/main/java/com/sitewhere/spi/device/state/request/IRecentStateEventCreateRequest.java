/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.state.request;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.device.event.DeviceEventType;

/**
 * Request used to create/update a recent device state event.
 */
public interface IRecentStateEventCreateRequest extends Serializable {

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

    /**
     * Get a string representation of the latest value.
     * 
     * @return
     */
    String getValue();

    /**
     * Get date event occurred.
     * 
     * @return
     */
    Date getEventDate();

    /**
     * Get unique event id.
     * 
     * @return
     */
    UUID getEventId();
}
