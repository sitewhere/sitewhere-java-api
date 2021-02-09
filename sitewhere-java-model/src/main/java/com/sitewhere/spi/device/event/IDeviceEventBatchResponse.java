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
package com.sitewhere.spi.device.event;

import java.util.List;

/**
 * Response generated when a batch of events has been processed.
 */
public interface IDeviceEventBatchResponse {

    /**
     * List of measurements that were created.
     * 
     * @return
     */
    List<IDeviceMeasurement> getCreatedMeasurements();

    /**
     * List of locations that were created.
     * 
     * @return
     */
    List<IDeviceLocation> getCreatedLocations();

    /**
     * List of alerts that were created.
     * 
     * @return
     */
    List<IDeviceAlert> getCreatedAlerts();
}