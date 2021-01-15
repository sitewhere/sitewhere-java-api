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
