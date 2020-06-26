/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Event that originates from a device.
 */
public interface IDeviceEvent extends IMetadataProvider, Serializable {

    /**
     * Get unique event identifier.
     * 
     * @return
     */
    UUID getId();

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
     * Get the date the event occurred.
     * 
     * @return
     */
    Date getEventDate();

    /**
     * Get the date this event was received.
     * 
     * @return
     */
    Date getReceivedDate();
}