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
package com.sitewhere.rest.model.device.group;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.spi.device.group.IDeviceGroup;

/**
 * Model object for a device group.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceGroup extends BrandedEntity implements IDeviceGroup {

    /** Serialization version identifier */
    private static final long serialVersionUID = -4993194128786517276L;

    /** Group name */
    private String name;

    /** Group description */
    private String description;

    /** List of roles */
    private List<String> roles = new ArrayList<String>();

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.group.IDeviceGroup#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.group.IDeviceGroup#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.group.IDeviceGroup#getRoles()
     */
    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }
}