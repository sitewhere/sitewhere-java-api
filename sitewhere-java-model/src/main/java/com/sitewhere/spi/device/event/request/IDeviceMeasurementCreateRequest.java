/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Interface for arguments needed to create a device measurement.
 */
public interface IDeviceMeasurementCreateRequest extends IDeviceEventCreateRequest, Serializable {

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
    BigDecimal getValue();
}