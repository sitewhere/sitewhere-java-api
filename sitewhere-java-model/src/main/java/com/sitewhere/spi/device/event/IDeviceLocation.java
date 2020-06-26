/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

/**
 * Location associated with a device assignment.
 */
public interface IDeviceLocation extends IDeviceEvent {

    /**
     * Get latitude value.
     * 
     * @return
     */
    Double getLatitude();

    /**
     * Get longitude value.
     * 
     * @return
     */
    Double getLongitude();

    /**
     * Get elevation value.
     * 
     * @return
     */
    Double getElevation();
}