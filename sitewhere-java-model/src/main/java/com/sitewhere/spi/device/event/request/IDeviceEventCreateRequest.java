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
package com.sitewhere.spi.device.event.request;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.device.event.DeviceEventType;

/**
 * Interface for arguments needed to create a device event.
 */
public interface IDeviceEventCreateRequest extends Serializable {

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
     * Get the date on which the event occurred.
     * 
     * @return
     */
    Date getEventDate();

    /**
     * Indicates whether state information on the device assignment should be
     * updated to reflect new event.
     * 
     * @return
     */
    boolean isUpdateState();

    /**
     * Get metadata values.
     * 
     * @return
     */
    Map<String, String> getMetadata();
}