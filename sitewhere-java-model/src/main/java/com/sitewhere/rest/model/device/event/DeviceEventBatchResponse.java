/**
 * Copyright © 2014-2021 The SiteWhere Authors
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

import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceEventBatchResponse;
import com.sitewhere.spi.device.event.IDeviceLocation;
import com.sitewhere.spi.device.event.IDeviceMeasurement;

/**
 * Response from device event batch create operation.
 */
public class DeviceEventBatchResponse implements IDeviceEventBatchResponse, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -5564589917811891744L;

    /** List of measurements that were created */
    private List<DeviceMeasurement> createdMeasurements = new ArrayList<DeviceMeasurement>();

    /** List of locations that were created */
    private List<DeviceLocation> createdLocations = new ArrayList<DeviceLocation>();

    /** List of alerts that were created */
    private List<DeviceAlert> createdAlerts = new ArrayList<DeviceAlert>();

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.IDeviceEventBatchResponse#getCreatedMeasurements ()
     */
    @SuppressWarnings("unchecked")
    public List<IDeviceMeasurement> getCreatedMeasurements() {
	return (List<IDeviceMeasurement>) (List<? extends IDeviceMeasurement>) createdMeasurements;
    }

    public void setCreatedMeasurements(List<DeviceMeasurement> createdMeasurements) {
	this.createdMeasurements = createdMeasurements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEventBatchResponse#getCreatedLocations()
     */
    @SuppressWarnings("unchecked")
    public List<IDeviceLocation> getCreatedLocations() {
	return (List<IDeviceLocation>) (List<? extends IDeviceLocation>) createdLocations;
    }

    public void setCreatedLocations(List<DeviceLocation> createdLocations) {
	this.createdLocations = createdLocations;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEventBatchResponse#getCreatedAlerts()
     */
    @SuppressWarnings("unchecked")
    public List<IDeviceAlert> getCreatedAlerts() {
	return (List<IDeviceAlert>) (List<? extends IDeviceAlert>) createdAlerts;
    }

    public void setCreatedAlerts(List<DeviceAlert> createdAlerts) {
	this.createdAlerts = createdAlerts;
    }
}