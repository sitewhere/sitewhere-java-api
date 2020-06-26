/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.request;

import com.sitewhere.spi.device.event.AlertLevel;
import com.sitewhere.spi.device.event.AlertSource;

/**
 * Interface for arguments needed to create a device alert.
 */
public interface IDeviceAlertCreateRequest extends IDeviceEventCreateRequest {

    /**
     * Get source of device alert.
     * 
     * @return
     */
    AlertSource getSource();

    /**
     * Get alert severity.
     * 
     * @return
     */
    AlertLevel getLevel();

    /**
     * Get the alert type indicator.
     * 
     * @return
     */
    String getType();

    /**
     * Get the alert message.
     * 
     * @return
     */
    String getMessage();
}