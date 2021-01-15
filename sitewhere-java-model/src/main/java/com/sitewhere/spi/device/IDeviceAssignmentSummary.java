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
package com.sitewhere.spi.device;

import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Summarizes basic details for a device assignment such as associated entities.
 */
public interface IDeviceAssignmentSummary extends IPersistentEntity {

    /**
     * Get id for device associated with assignment.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get token for device associated with assignment.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get id for device type associated with assignment.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Get name for device type associated with assignment.
     * 
     * @return
     */
    String getDeviceTypeName();

    /**
     * Get image url for device type associated with assignment.
     * 
     * @return
     */
    String getDeviceTypeImageUrl();

    /**
     * Get unqiue id for customer assigned to device.
     * 
     * @return
     */
    UUID getCustomerId();

    /**
     * Get customer name.
     * 
     * @return
     */
    String getCustomerName();

    /**
     * Get customer image url.
     * 
     * @return
     */
    String getCustomerImageUrl();

    /**
     * Get unique id for area assigned to device.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get area name.
     * 
     * @return
     */
    String getAreaName();

    /**
     * Get area image url.
     * 
     * @return
     */
    String getAreaImageUrl();

    /**
     * Get asset id.
     * 
     * @return
     */
    UUID getAssetId();

    /**
     * Get asset name.
     * 
     * @return
     */
    String getAssetName();

    /**
     * Get asset image url.
     * 
     * @return
     */
    String getAssetImageUrl();

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
