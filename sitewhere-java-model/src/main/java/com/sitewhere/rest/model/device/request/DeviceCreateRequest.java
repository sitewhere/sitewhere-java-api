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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.device.IDeviceElementMapping;
import com.sitewhere.spi.device.request.IDeviceCreateRequest;

/**
 * Fields needed to create/update a device.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceCreateRequest extends PersistentEntityCreateRequest implements IDeviceCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 5102270168736590229L;

    /** Device type token */
    private String deviceTypeToken;

    /** Parent device token (if nested) */
    private String parentDeviceToken;

    /** Indicates whether parent hardware id should be removed */
    private Boolean removeParentHardwareId;

    /** List of device element mappings */
    private List<? extends IDeviceElementMapping> deviceElementMappings;

    /** Comments */
    private String comments;

    /** Device status indicator */
    private String status;

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceCreateRequest#getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceCreateRequest#getParentDeviceToken()
     */
    @Override
    public String getParentDeviceToken() {
	return parentDeviceToken;
    }

    public void setParentDeviceToken(String parentDeviceToken) {
	this.parentDeviceToken = parentDeviceToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceCreateRequest#
     * isRemoveParentHardwareId()
     */
    @Override
    public Boolean isRemoveParentHardwareId() {
	return removeParentHardwareId;
    }

    public void setRemoveParentHardwareId(Boolean removeParentHardwareId) {
	this.removeParentHardwareId = removeParentHardwareId;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceCreateRequest#
     * getDeviceElementMappings()
     */
    @Override
    public List<? extends IDeviceElementMapping> getDeviceElementMappings() {
	return deviceElementMappings;
    }

    public void setDeviceElementMappings(List<? extends IDeviceElementMapping> deviceElementMappings) {
	this.deviceElementMappings = deviceElementMappings;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceCreateRequest#getComments()
     */
    @Override
    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceCreateRequest#getStatus()
     */
    @Override
    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public static class Builder {

	/** Request being built */
	private DeviceCreateRequest request = new DeviceCreateRequest();

	public Builder(String deviceTypeToken, String token) {
	    request.setDeviceTypeToken(deviceTypeToken);
	    request.setToken(token);
	    request.setStatus(null);
	    request.setComments("");
	}

	public Builder withComment(String comments) {
	    request.setComments(comments);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceCreateRequest build() {
	    return request;
	}
    }
}