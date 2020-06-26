/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.util.UUID;

import com.sitewhere.spi.common.IColorProvider;
import com.sitewhere.spi.common.IIconProvider;
import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Indicates a possible status for a device. A device status is tied to a device
 * type and can be used for customizing user interfaces.
 */
public interface IDeviceStatus extends IPersistentEntity, IColorProvider, IIconProvider {

    /**
     * Get the unique status code.
     * 
     * @return
     */
    String getCode();

    /**
     * Get unqiue id for the parent device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Name displayed in user interface.
     * 
     * @return
     */
    String getName();
}