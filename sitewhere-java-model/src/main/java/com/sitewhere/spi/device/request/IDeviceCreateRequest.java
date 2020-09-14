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

import java.util.List;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.device.IDeviceElementMapping;

/**
 * Interface for arguments needed to create a device.
 */
public interface IDeviceCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get the device type token.
     * 
     * @return
     */
    String getDeviceTypeToken();

    /**
     * Get parent device token (if nested).
     * 
     * @return
     */
    String getParentDeviceToken();

    /**
     * Indicates whether parent reference should be removed.
     * 
     * @return
     */
    Boolean isRemoveParentHardwareId();

    /**
     * Get the list of device element mappings.
     * 
     * @return
     */
    List<? extends IDeviceElementMapping> getDeviceElementMappings();

    /**
     * Get comments associated with device.
     * 
     * @return
     */
    String getComments();

    /**
     * Get device status indicator code.
     * 
     * @return
     */
    String getStatus();
}