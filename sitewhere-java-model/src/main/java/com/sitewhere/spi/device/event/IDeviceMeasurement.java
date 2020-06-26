/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

import java.io.Serializable;

/**
 * Measurement associated with a device assignment at a point in time.
 */
public interface IDeviceMeasurement extends IDeviceEvent, Serializable {

    /**
     * Get measurement name.
     * 
     * @return
     */
    String getName();

    /**
     * Get measurement value.
     * 
     * @return
     */
    Double getValue();
}