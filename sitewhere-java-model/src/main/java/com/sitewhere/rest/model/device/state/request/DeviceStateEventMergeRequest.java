/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.state.request;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceLocation;
import com.sitewhere.spi.device.event.IDeviceMeasurement;
import com.sitewhere.spi.device.state.request.IDeviceStateEventMergeRequest;

/**
 * Model for listing events to be merged into device state.
 */
public class DeviceStateEventMergeRequest implements IDeviceStateEventMergeRequest {

    /** List of locations to add */
    private List<IDeviceLocation> locations = new ArrayList<>();

    /** List of measurements to add */
    private List<IDeviceMeasurement> measurements = new ArrayList<>();

    /** List of alerts to add */
    private List<IDeviceAlert> alerts = new ArrayList<>();

    /*
     * @see com.sitewhere.spi.device.state.request.IDeviceStateEventMergeRequest#
     * getLocations()
     */
    @Override
    public List<IDeviceLocation> getLocations() {
	return locations;
    }

    /*
     * @see com.sitewhere.spi.device.state.request.IDeviceStateEventMergeRequest#
     * getMeasurements()
     */
    @Override
    public List<IDeviceMeasurement> getMeasurements() {
	return measurements;
    }

    /*
     * @see com.sitewhere.spi.device.state.request.IDeviceStateEventMergeRequest#
     * getAlerts()
     */
    @Override
    public List<IDeviceAlert> getAlerts() {
	return alerts;
    }
}
