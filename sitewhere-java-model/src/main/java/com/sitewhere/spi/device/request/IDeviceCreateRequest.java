/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

import java.util.List;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.device.IDeviceElementMapping;

/**
 * Interface for arguments needed to create a device.
 */
public interface IDeviceCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get the device type token.
     * 
     * @return
     */
    String getDeviceTypeToken();

    /**
     * Get parent device token (if nested).
     * 
     * @return
     */
    String getParentDeviceToken();

    /**
     * Indicates whether parent reference should be removed.
     * 
     * @return
     */
    Boolean isRemoveParentHardwareId();

    /**
     * Get the list of device element mappings.
     * 
     * @return
     */
    List<? extends IDeviceElementMapping> getDeviceElementMappings();

    /**
     * Get comments associated with device.
     * 
     * @return
     */
    String getComments();

    /**
     * Get device status indicator code.
     * 
     * @return
     */
    String getStatus();
}