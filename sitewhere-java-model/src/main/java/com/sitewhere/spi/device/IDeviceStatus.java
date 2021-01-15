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

import com.sitewhere.spi.common.IColorProvider;
import com.sitewhere.spi.common.IIconProvider;
import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Indicates a possible status for a device. A device status is tied to a device
 * type and can be used for customizing user interfaces.
 */
public interface IDeviceStatus extends IPersistentEntity, IColorProvider, IIconProvider {

    /**
     * Get the unique status code.
     * 
     * @return
     */
    String getCode();

    /**
     * Get unqiue id for the parent device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Name displayed in user interface.
     * 
     * @return
     */
    String getName();
}