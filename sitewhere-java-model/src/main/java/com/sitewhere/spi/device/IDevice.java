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
import com.sitewhere.spi.device.element.IDeviceElementSchema;

/**
 * Interface for a SiteWhere device.
 */
public interface IDevice extends IPersistentEntity {

    /**
     * Get unique id for associated device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * If contained by a parent device, returns the parent device id.
     * 
     * @return
     */
    UUID getParentDeviceId();

    /**
     * Gets mappings of {@link IDeviceElementSchema} paths to hardware ids for
     * nested devices.
     * 
     * @return
     */
    List<? extends IDeviceElementMapping> getDeviceElementMappings();

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
}