/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.state;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.sitewhere.spi.device.event.IDeviceMeasurementContent;

/**
 * Annotation of a recent device measurement event.
 */
public interface IRecentMeasurementEvent extends IRecentStateEvent, IDeviceMeasurementContent, Serializable {

    /**
     * Get maximum value for measurement.
     * 
     * @return
     */
    BigDecimal getMaxValue();

    /**
     * Get date when maximum value occurred.
     * 
     * @return
     */
    Date getMaxValueDate();

    /**
     * Get minimum value for measurement.
     * 
     * @return
     */
    BigDecimal getMinValue();

    /**
     * Get date when minimum value occurred.
     * 
     * @return
     */
    Date getMinValueDate();
}
