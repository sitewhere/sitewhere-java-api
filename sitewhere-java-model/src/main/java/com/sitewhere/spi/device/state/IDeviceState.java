/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.state;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Contains most recent state information for a device.
 */
public interface IDeviceState extends IMetadataProvider, Serializable {

    /**
     * Get id.
     * 
     * @return
     */
    UUID getId();

    /**
     * Get device id.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get device assignment id.
     * 
     * @return
     */
    UUID getDeviceAssignmentId();

    /**
     * Get device type id.
     * 
     * @return
     */
    UUID getDeviceTypeId();

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
