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
package com.sitewhere.rest.model.device.element;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.device.element.IDeviceElement;

/**
 * Default implementation of {@link IDeviceElement}.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceElement extends PersistentEntity implements IDeviceElement {

    /** Serialization version identifier */
    private static final long serialVersionUID = 8334544031222730874L;

    /** Element name */
    private String name;

    /** Path relative to parent */
    private String path;

    public DeviceElement() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.element.IDeviceElement#getName()
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.element.IDeviceElement#getPath()
     */
    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }
}