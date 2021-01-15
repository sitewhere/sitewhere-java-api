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
package com.sitewhere.rest.model.device.request;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.rest.model.device.element.DeviceElementSchema;
import com.sitewhere.rest.model.device.element.DeviceSlot;
import com.sitewhere.rest.model.device.element.DeviceUnit;
import com.sitewhere.spi.device.DeviceContainerPolicy;
import com.sitewhere.spi.device.request.IDeviceTypeCreateRequest;

/**
 * Holds fields needed to create a new device specification.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceTypeCreateRequest extends BrandedEntityCreateRequest implements IDeviceTypeCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 1L;

    /** Name */
    private String name;

    /** Decription */
    private String description;

    /** Indicates if device instances can contain nested devices */
    private DeviceContainerPolicy containerPolicy;

    /** Device element schema for specifications that support nested devices */
    private String deviceElementSchemaToken;

    /*
     * @see com.sitewhere.spi.device.request.IDeviceTypeCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceTypeCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceTypeCreateRequest#getContainerPolicy(
     * )
     */
    @Override
    public DeviceContainerPolicy getContainerPolicy() {
	return containerPolicy;
    }

    public void setContainerPolicy(DeviceContainerPolicy containerPolicy) {
	this.containerPolicy = containerPolicy;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceTypeCreateRequest#
     * getDeviceElementSchemaToken()
     */
    @Override
    public String getDeviceElementSchemaToken() {
	return deviceElementSchemaToken;
    }

    public void setDeviceElementSchemaToken(String deviceElementSchemaToken) {
	this.deviceElementSchemaToken = deviceElementSchemaToken;
    }

    public static class Builder {

	/** Request being built */
	private DeviceTypeCreateRequest request = new DeviceTypeCreateRequest();

	public Builder(String token, String name) {
	    request.setToken(token);
	    request.setName(name);
	    request.setContainerPolicy(DeviceContainerPolicy.Standalone);
	    request.setImageUrl("https://s3.amazonaws.com/sitewhere-demo/broken-link.png");
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withImageUrl(String imageUrl) {
	    request.setImageUrl(imageUrl);
	    return this;
	}

	public Builder makeComposite() {
	    request.setContainerPolicy(DeviceContainerPolicy.Composite);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceTypeCreateRequest build() {
	    return request;
	}
    }

    public static class DeviceElementSchemaBuilder {

	private DeviceElementSchema schema = new DeviceElementSchema();

	public DeviceUnitBuilder addUnit(String name, String path) {
	    DeviceUnitBuilder unit = new DeviceUnitBuilder(name, path);
	    schema.getDeviceUnits().add(unit.build());
	    return unit;
	}

	public DeviceElementSchemaBuilder addSlot(String name, String path) {
	    DeviceSlot slot = new DeviceSlot();
	    slot.setName(name);
	    slot.setPath(path);
	    schema.getDeviceSlots().add(slot);
	    return this;
	}

	public DeviceElementSchema build() {
	    return schema;
	}
    }

    public static class DeviceUnitBuilder {

	private DeviceUnit unit = new DeviceUnit();

	public DeviceUnitBuilder(String name, String path) {
	    unit.setName(name);
	    unit.setPath(path);
	}

	public DeviceUnitBuilder addUnit(String name, String path) {
	    DeviceUnitBuilder sub = new DeviceUnitBuilder(name, path);
	    unit.getDeviceUnits().add(sub.build());
	    return sub;
	}

	public DeviceUnitBuilder addSlot(String name, String path) {
	    DeviceSlot slot = new DeviceSlot();
	    slot.setName(name);
	    slot.setPath(path);
	    unit.getDeviceSlots().add(slot);
	    return this;
	}

	public DeviceUnit build() {
	    return unit;
	}
    }
}