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
import com.sitewhere.spi.device.element.IDeviceElementSchema;

/**
 * Interface for a SiteWhere device.
 */
public interface IDevice extends IPersistentEntity {

    /**
     * Get unique id for associated device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * If contained by a parent device, returns the parent device id.
     * 
     * @return
     */
    UUID getParentDeviceId();

    /**
     * Gets mappings of {@link IDeviceElementSchema} paths to hardware ids for
     * nested devices.
     * 
     * @return
     */
    List<? extends IDeviceElementMapping> getDeviceElementMappings();

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
}