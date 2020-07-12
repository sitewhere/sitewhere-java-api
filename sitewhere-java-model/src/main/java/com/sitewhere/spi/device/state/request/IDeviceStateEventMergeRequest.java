/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.state.request;

import java.util.List;

import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceLocation;
import com.sitewhere.spi.device.event.IDeviceMeasurement;

/**
 * Request for merging events into the device state.
 */
public interface IDeviceStateEventMergeRequest {

    /**
     * Get locations to be merged.
     * 
     * @return
     */
    List<IDeviceLocation> getLocations();

    /**
     * Get measurements to be merged.
     * 
     * @return
     */
    List<IDeviceMeasurement> getMeasurements();

    /**
     * Get alerts to be merged.
     * 
     * @return
     */
    List<IDeviceAlert> getAlerts();
}
