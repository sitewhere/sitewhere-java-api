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
package com.sitewhere.spi.device.command;

import java.util.List;
import java.util.UUID;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.IPersistentEntity;

/**
 * A parameterized command issued to a device.
 */
public interface IDeviceCommand extends IPersistentEntity, IAccessible {

    /**
     * Get unique id of parent device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Optional namespace for distinguishing commands.
     * 
     * @return
     */
    String getNamespace();

    /**
     * Get list of parameters.
     * 
     * @return
     */
    List<? extends ICommandParameter> getParameters();
}