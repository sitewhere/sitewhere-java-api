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
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.device.group.IDeviceGroup;
import com.sitewhere.spi.device.group.IDeviceGroupElement;

/**
 * Model object for an element in an {@link IDeviceGroup}.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceGroupElement extends PersistentEntity implements IDeviceGroupElement {

    /** Serialization version identifier */
    private static final long serialVersionUID = -5565956152579362877L;

    /** Parent group id */
    private UUID groupId;

    /** Device id (null if nested group id specified) */
    private UUID deviceId;

    /** Nested group id (null if device id specified) */
    private UUID nestedGroupId;

    /** List of roles for the element */
    private List<String> roles = new ArrayList<String>();

    /*
     * @see com.sitewhere.spi.device.group.IDeviceGroupElement#getGroupId()
     */
    @Override
    public UUID getGroupId() {
	return groupId;
    }

    public void setGroupId(UUID groupId) {
	this.groupId = groupId;
    }

    /*
     * @see com.sitewhere.spi.device.group.IDeviceGroupElement#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * @see com.sitewhere.spi.device.group.IDeviceGroupElement#getNestedGroupId()
     */
    @Override
    public UUID getNestedGroupId() {
	return nestedGroupId;
    }

    public void setNestedGroupId(UUID nestedGroupId) {
	this.nestedGroupId = nestedGroupId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.group.IDeviceGroupElement#getRoles()
     */
    @Override
    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }
}