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
package com.sitewhere.spi.device.element;

import java.io.Serializable;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Common base class for elements in the {@link IDeviceElementSchema} hierarchy.
 */
public interface IDeviceElement extends IPersistentEntity, Serializable {

    /**
     * Get human-readable name for element.
     * 
     * @return
     */
    String getName();

    /**
     * Get relative path to element from parent.
     * 
     * @return
     */
    String getPath();
}