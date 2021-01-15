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

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Indicates an alarm condition that potentially requires human intervention.
 */
public interface IDeviceAlarm extends IMetadataProvider {

    /**
     * Get unique identifier.
     * 
     * @return
     */
    UUID getId();

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
     * Get alarm message.
     * 
     * @return
     */
    String getAlarmMessage();

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

    /**
     * Get date the alarm was triggered.
     * 
     * @return
     */
    Date getTriggeredDate();

    /**
     * Get date the alarm was acknowledged.
     * 
     * @return
     */
    Date getAcknowledgedDate();

    /**
     * Get date the alarm was resolved.
     * 
     * @return
     */
    Date getResolvedDate();
}