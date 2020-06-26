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

/**
 * Provides data pertaining to recent device state.
 */
public interface IDeviceStateCreateRequest extends Serializable {

    /**
     * Get device id.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get device type id.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Get device assignment id.
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
     * Get date of last device interaction.
     * 
     * @return
     */
    Date getLastInteractionDate();

    /**
     * Get date device was marked as missing.
     * 
     * @return
     */
    Date getPresenceMissingDate();
}
