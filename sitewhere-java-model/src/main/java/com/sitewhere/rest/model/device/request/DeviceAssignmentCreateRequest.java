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
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.device.DeviceAssignmentStatus;
import com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest;

/**
 * Holds fields needed to create a device assignment.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceAssignmentCreateRequest extends PersistentEntityCreateRequest
	implements IDeviceAssignmentCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = -6880578458870122016L;

    /** Device token */
    private String deviceToken;

    /** Customer token */
    private String customerToken;

    /** Area token */
    private String areaToken;

    /** Asset token */
    private String assetToken;

    /** Status */
    private DeviceAssignmentStatus status;

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest#
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
     * @see com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest#
     * getCustomerToken()
     */
    @Override
    public String getCustomerToken() {
	return customerToken;
    }

    public void setCustomerToken(String customerToken) {
	this.customerToken = customerToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest#getAreaToken(
     * )
     */
    @Override
    public String getAreaToken() {
	return areaToken;
    }

    public void setAreaToken(String areaToken) {
	this.areaToken = areaToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest#getAssetToken
     * ()
     */
    @Override
    public String getAssetToken() {
	return assetToken;
    }

    public void setAssetToken(String assetToken) {
	this.assetToken = assetToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAssignmentCreateRequest#getStatus()
     */
    @Override
    public DeviceAssignmentStatus getStatus() {
	return status;
    }

    public void setStatus(DeviceAssignmentStatus status) {
	this.status = status;
    }

    public static class Builder {

	/** Request being built */
	private DeviceAssignmentCreateRequest request = new DeviceAssignmentCreateRequest();

	public Builder(String deviceToken, String customerToken, String areaToken, String assetToken) {
	    request.setDeviceToken(deviceToken);
	    request.setCustomerToken(customerToken);
	    request.setAreaToken(areaToken);
	    request.setAssetToken(assetToken);
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceAssignmentCreateRequest build() {
	    return request;
	}
    }
}