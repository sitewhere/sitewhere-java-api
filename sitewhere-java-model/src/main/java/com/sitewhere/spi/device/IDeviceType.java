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

import java.util.UUID;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.IBrandedEntity;

/**
 * Specifies details about a given type of device.
 */
public interface IDeviceType extends IBrandedEntity, IAccessible {

    /**
     * Indicates whether this device contains other devices.
     * 
     * @return
     */
    DeviceContainerPolicy getContainerPolicy();

    /**
     * Get schema that describes how nested devices are arranged.
     * 
     * @return
     */
    UUID getDeviceElementSchemaId();
}