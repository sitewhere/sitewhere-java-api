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

import com.sitewhere.spi.device.event.request.IDeviceAlertCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceMeasurementCreateRequest;

/**
 * Used to create multiple events for a given device.
 */
public interface IDeviceEventBatch {

    /**
     * Unique device token.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get a list of device measurements create requests.
     * 
     * @return
     */
    List<IDeviceMeasurementCreateRequest> getMeasurements();

    /**
     * Get a list of device location create requests.
     * 
     * @return
     */
    List<IDeviceLocationCreateRequest> getLocations();

    /**
     * Get a list of device alert create requests.
     * 
     * @return
     */
    List<IDeviceAlertCreateRequest> getAlerts();
}