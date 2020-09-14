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
package com.sitewhere.rest.model.device;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.spi.device.DeviceContainerPolicy;
import com.sitewhere.spi.device.IDeviceType;

/**
 * Model object for device specification information.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceType extends BrandedEntity implements IDeviceType {

    /** Serialization version identifier */
    private static final long serialVersionUID = -2798346634280966544L;

    /** Name */
    private String name;

    /** Decription */
    private String description;

    /** Device container policy */
    private DeviceContainerPolicy containerPolicy = DeviceContainerPolicy.Standalone;

    /** Id of that specifies allowable locations of nested devices */
    private UUID deviceElementSchemaId;

    /*
     * @see com.sitewhere.spi.device.IDeviceType#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceType#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceType#getContainerPolicy()
     */
    @Override
    public DeviceContainerPolicy getContainerPolicy() {
	return containerPolicy;
    }

    public void setContainerPolicy(DeviceContainerPolicy containerPolicy) {
	this.containerPolicy = containerPolicy;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceType#getDeviceElementSchemaId()
     */
    @Override
    public UUID getDeviceElementSchemaId() {
	return deviceElementSchemaId;
    }

    public void setDeviceElementSchemaId(UUID deviceElementSchemaId) {
	this.deviceElementSchemaId = deviceElementSchemaId;
    }
}