/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.util.List;
import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Summarizes device and directly related entities such as device type and
 * assignments.
 */
public interface IDeviceSummary extends IPersistentEntity {

    /**
     * Get unique id for associated device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Get device type name.
     * 
     * @return
     */
    String getDeviceTypeName();

    /**
     * Get device type image url.
     * 
     * @return
     */
    String getDeviceTypeImageUrl();

    /**
     * If contained by a parent device, returns the parent device id.
     * 
     * @return
     */
    UUID getParentDeviceId();

    /**
     * Get device comments.
     * 
     * @return
     */
    String getComments();

    /**
     * Get most recent device status.
     * 
     * @return
     */
    String getStatus();

    /**
     * Get list of device assignment summaries.
     * 
     * @return
     */
    List<? extends IDeviceAssignmentSummary> getDeviceAssignmentSummaries();
}
