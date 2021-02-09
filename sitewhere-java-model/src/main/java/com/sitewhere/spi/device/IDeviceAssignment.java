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
package com.sitewhere.spi.device;

import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Assigns a device to a customer, area, and/or asset so that events may be
 * associated with those entities.
 */
public interface IDeviceAssignment extends IPersistentEntity {

    /**
     * Get unique id for assigned device.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get unique id for assigned device type at time of assignment.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Get unqiue id for customer assigned to device.
     * 
     * @return
     */
    UUID getCustomerId();

    /**
     * Get unique id for area assigned to device.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get asset id.
     * 
     * @return
     */
    UUID getAssetId();

    /**
     * Get the device assignment status.
     * 
     * @return
     */
    DeviceAssignmentStatus getStatus();

    /**
     * Get the date/time at which the assignment was made active.
     * 
     * @return
     */
    Date getActiveDate();

    /**
     * Get the date/time at which the assignment was released.
     * 
     * @return
     */
    Date getReleasedDate();
}