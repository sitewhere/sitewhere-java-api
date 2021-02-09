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
package com.sitewhere.rest.model.device.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.device.group.IDeviceGroup;
import com.sitewhere.spi.device.request.IDeviceGroupCreateRequest;

/**
 * Holds fields needed to create a new device group.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceGroupCreateRequest extends BrandedEntityCreateRequest implements IDeviceGroupCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 1657559631108464556L;

    /** Group name */
    private String name;

    /** Group description */
    private String description;

    /** List of roles */
    private List<String> roles;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceGroupCreateRequest#getName()
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
     * @see
     * com.sitewhere.spi.device.request.IDeviceGroupCreateRequest#getDescription ()
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
     * @see com.sitewhere.spi.device.request.IDeviceGroupCreateRequest#getRoles()
     */
    @Override
    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

    public static class Builder {

	/** Request being built */
	private DeviceGroupCreateRequest request = new DeviceGroupCreateRequest();

	public Builder(IDeviceGroup api) {
	    request.setToken(api.getToken());
	    request.setName(api.getName());
	    request.setDescription(api.getDescription());
	    if (request.getRoles() != null) {
		request.setRoles(new ArrayList<String>());
		request.getRoles().addAll(api.getRoles());
	    }
	    if (api.getMetadata() != null) {
		request.setMetadata(new HashMap<String, String>());
		request.getMetadata().putAll(api.getMetadata());
	    }
	}

	public Builder(String token, String name) {
	    request.setToken(token);
	    request.setName(name);
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

	public Builder withRole(String role) {
	    if (request.getRoles() == null) {
		request.setRoles(new ArrayList<String>());
	    }
	    request.getRoles().add(role);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceGroupCreateRequest build() {
	    return request;
	}
    }
}