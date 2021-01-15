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
package com.sitewhere.spi.device.group;

import java.util.List;
import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Interface for an entry in an {@link IDeviceGroup}.
 */
public interface IDeviceGroupElement extends IPersistentEntity {

    /**
     * Get id for parent group.
     * 
     * @return
     */
    UUID getGroupId();

    /**
     * Get id of device (only one of device id or nested group id should be
     * specified).
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get id of nested group (only one of device id or nested group id should be
     * specified).
     * 
     * @return
     */
    UUID getNestedGroupId();

    /**
     * Get list of roles associated with element.
     * 
     * @return
     */
    List<String> getRoles();
}