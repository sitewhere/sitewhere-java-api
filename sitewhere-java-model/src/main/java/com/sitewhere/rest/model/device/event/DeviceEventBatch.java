/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.rest.model.device.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.event.request.DeviceAlertCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.spi.device.event.IDeviceEventBatch;
import com.sitewhere.spi.device.event.request.IDeviceAlertCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceMeasurementCreateRequest;

/**
 * A batch of new events to create for a given device.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceEventBatch implements IDeviceEventBatch, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -6779882564394545114L;

    /** Device token */
    private String deviceToken;

    /** List of measurements requests */
    private List<DeviceMeasurementCreateRequest> measurements = new ArrayList<DeviceMeasurementCreateRequest>();

    /** List of location requests */
    private List<DeviceLocationCreateRequest> locations = new ArrayList<DeviceLocationCreateRequest>();

    /** List of alert requests */
    private List<DeviceAlertCreateRequest> alerts = new ArrayList<DeviceAlertCreateRequest>();

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventBatch#getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEventBatch#getMeasurements()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<IDeviceMeasurementCreateRequest> getMeasurements() {
	return (List<IDeviceMeasurementCreateRequest>) (List<? extends IDeviceMeasurementCreateRequest>) measurements;
    }

    public void setMeasurements(List<DeviceMeasurementCreateRequest> measurements) {
	this.measurements = measurements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEventBatch#getLocations()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<IDeviceLocationCreateRequest> getLocations() {
	return (List<IDeviceLocationCreateRequest>) (List<? extends IDeviceLocationCreateRequest>) locations;
    }

    public void setLocations(List<DeviceLocationCreateRequest> locations) {
	this.locations = locations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEventBatch#getAlerts()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<IDeviceAlertCreateRequest> getAlerts() {
	return (List<IDeviceAlertCreateRequest>) (List<? extends IDeviceAlertCreateRequest>) alerts;
    }

    public void setAlerts(List<DeviceAlertCreateRequest> alerts) {
	this.alerts = alerts;
    }
}