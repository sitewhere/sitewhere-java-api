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

import java.util.List;
import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Summarizes device and directly related entities such as device type and
 * assignments.
 */
public interface IDeviceSummary extends IPersistentEntity {

    /**
     * Get unique id for associated device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Get device type name.
     * 
     * @return
     */
    String getDeviceTypeName();

    /**
     * Get device type image url.
     * 
     * @return
     */
    String getDeviceTypeImageUrl();

    /**
     * If contained by a parent device, returns the parent device id.
     * 
     * @return
     */
    UUID getParentDeviceId();

    /**
     * Get device comments.
     * 
     * @return
     */
    String getComments();

    /**
     * Get most recent device status.
     * 
     * @return
     */
    String getStatus();

    /**
     * Get list of device assignment summaries.
     * 
     * @return
     */
    List<? extends IDeviceAssignmentSummary> getDeviceAssignmentSummaries();
}
