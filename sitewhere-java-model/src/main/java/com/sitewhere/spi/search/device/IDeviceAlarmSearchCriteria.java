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
package com.sitewhere.spi.search.device;

import java.util.UUID;

import com.sitewhere.spi.device.DeviceAlarmState;
import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria used to search for device alarms.
 */
public interface IDeviceAlarmSearchCriteria extends ISearchCriteria {

    /**
     * Get device id.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get assignment id.
     * 
     * @return
     */
    UUID getDeviceAssignmentId();

    /**
     * Get customer id if assigned.
     * 
     * @return
     */
    UUID getCustomerId();

    /**
     * Get area id if assigned.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get asset id if assigned.
     * 
     * @return
     */
    UUID getAssetId();

    /**
     * Get event id that triggered alarm.
     * 
     * @return
     */
    UUID getTriggeringEventId();

    /**
     * Get alarm state.
     * 
     * @return
     */
    DeviceAlarmState getState();
}