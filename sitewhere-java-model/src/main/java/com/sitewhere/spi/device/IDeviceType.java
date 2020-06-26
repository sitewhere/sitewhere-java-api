/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.util.UUID;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.IBrandedEntity;

/**
 * Specifies details about a given type of device.
 */
public interface IDeviceType extends IBrandedEntity, IAccessible {

    /**
     * Indicates whether this device contains other devices.
     * 
     * @return
     */
    DeviceContainerPolicy getContainerPolicy();

    /**
     * Get schema that describes how nested devices are arranged.
     * 
     * @return
     */
    UUID getDeviceElementSchemaId();
}