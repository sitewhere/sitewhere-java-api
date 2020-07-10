/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

/**
 * Content associated with a device alert.
 */
public interface IDeviceAlertContent {

    /**
     * Get source of the alert.
     * 
     * @return
     */
    AlertSource getSource();

    /**
     * Get severity of alert.
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
