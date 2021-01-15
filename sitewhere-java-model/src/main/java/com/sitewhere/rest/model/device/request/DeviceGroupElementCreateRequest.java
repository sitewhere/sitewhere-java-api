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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.device.request.IDeviceGroupElementCreateRequest;

/**
 * Holds fields needed to create a new device group element.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceGroupElementCreateRequest extends PersistentEntityCreateRequest
	implements IDeviceGroupElementCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 652319724175005277L;

    /** Device token (null if nested group supplied) */
    private String deviceToken;

    /** Nested group token (null if device supplied) */
    private String nestedGroupToken;

    /** List of roles for element */
    private List<String> roles = new ArrayList<String>();

    /*
     * @see com.sitewhere.spi.device.request.IDeviceGroupElementCreateRequest#
     * getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceGroupElementCreateRequest#
     * getNestedGroupToken()
     */
    @Override
    public String getNestedGroupToken() {
	return nestedGroupToken;
    }

    public void setNestedGroupToken(String nestedGroupToken) {
	this.nestedGroupToken = nestedGroupToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceGroupElementCreateRequest#getRoles()
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
	private DeviceGroupElementCreateRequest request = new DeviceGroupElementCreateRequest();

	public Builder(String deviceToken) {
	    request.setDeviceToken(deviceToken);
	}

	public Builder asGroup() {
	    request.setNestedGroupToken(request.getDeviceToken());
	    request.setDeviceToken(null);
	    return this;
	}

	public Builder withRole(String role) {
	    request.getRoles().add(role);
	    return this;
	}

	public DeviceGroupElementCreateRequest build() {
	    return request;
	}
    }
}