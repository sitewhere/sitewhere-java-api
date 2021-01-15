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
package com.sitewhere.spi.device.event;

import java.util.Map;
import java.util.UUID;

import com.sitewhere.spi.device.DeviceAssignmentStatus;

/**
 * Provides contextual information about a device event. This is a combination
 * of device and assignment data that might be used in outbound processors or
 * for rule calculations.
 */
public interface IDeviceEventContext {

    /**
     * Get device token.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get originator.
     * 
     * @return
     */
    String getOriginator();

    /**
     * Get source id.
     * 
     * @return
     */
    String getSourceId();

    /**
     * Get the unique id of the device.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get id for device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * If contained by a parent device, returns the parent id.
     * 
     * @return
     */
    UUID getParentDeviceId();

    /**
     * Get most recent device status.
     * 
     * @return
     */
    String getDeviceStatus();

    /**
     * Get a map of device metadata.
     * 
     * @return
     */
    Map<String, String> getDeviceMetadata();

    /**
     * Get the unique id of the device.
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
     * Get the device assignment status.
     * 
     * @return
     */
    DeviceAssignmentStatus getDeviceAssignmentStatus();

    /**
     * Get a map of device assignment metadata.
     * 
     * @return
     */
    Map<String, String> getDeviceAssignmentMetadata();
}