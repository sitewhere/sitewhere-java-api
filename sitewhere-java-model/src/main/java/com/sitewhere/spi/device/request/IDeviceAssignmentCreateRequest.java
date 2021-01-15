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
package com.sitewhere.spi.device.request;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.device.DeviceAssignmentStatus;

/**
 * Interface for arguments needed to create a device assignment.
 */
public interface IDeviceAssignmentCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get the device token.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get token of customer if assigned.
     * 
     * @return
     */
    String getCustomerToken();

    /**
     * Get token of area if assigned.
     * 
     * @return
     */
    String getAreaToken();

    /**
     * Get token of asset if assigned.
     * 
     * @return
     */
    String getAssetToken();

    /**
     * Get the device assignment status.
     * 
     * @return
     */
    DeviceAssignmentStatus getStatus();
}