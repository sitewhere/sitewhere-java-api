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
package com.sitewhere.spi.device;

import java.io.Serializable;

import com.sitewhere.spi.device.element.IDeviceElementSchema;

/**
 * Maps a location in an {@link IDeviceElementSchema} to an {@link IDevice}.
 */
public interface IDeviceElementMapping extends Serializable {

    /**
     * Get path in {@link IDeviceElementSchema} being mapped.
     * 
     * @return
     */
    String getDeviceElementSchemaPath();

    /**
     * Get token of {@link IDevice} being mapped.
     * 
     * @return
     */
    String getDeviceToken();
}