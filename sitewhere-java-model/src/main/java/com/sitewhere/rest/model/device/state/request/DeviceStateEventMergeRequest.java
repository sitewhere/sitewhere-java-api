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
