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

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Event that originates from a device.
 */
public interface IDeviceEvent extends IMetadataProvider, Serializable {

    /**
     * Get unique event identifier.
     * 
     * @return
     */
    UUID getId();

    /**
     * Get alternate id that can be used for correlating events with external
     * systems and for deduplication.
     * 
     * @return
     */
    String getAlternateId();

    /**
     * Get event type indicator.
     * 
     * @return
     */
    DeviceEventType getEventType();

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
     * Get the date the event occurred.
     * 
     * @return
     */
    Date getEventDate();

    /**
     * Get the date this event was received.
     * 
     * @return
     */
    Date getReceivedDate();
}