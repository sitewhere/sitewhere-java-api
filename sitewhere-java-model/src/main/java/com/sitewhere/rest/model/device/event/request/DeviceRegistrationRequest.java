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
package com.sitewhere.rest.model.device.event.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.request.DeviceCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceRegistrationRequest;

/**
 * Default model implementation of {@link IDeviceRegistrationRequest}.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceRegistrationRequest extends DeviceCreateRequest implements IDeviceRegistrationRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 6079525813334392482L;

    /** Customer token */
    private String customerToken;

    /** Area token */
    private String areaToken;

    /** Asset token */
    private String assetToken;
    
    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceRegistrationRequest#
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
     * @see com.sitewhere.spi.device.event.request.IDeviceRegistrationRequest#
     * getAreaToken()
     */
    @Override
    public String getAreaToken() {
	return areaToken;
    }

    public void setAreaToken(String areaToken) {
	this.areaToken = areaToken;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceRegistrationRequest#
     * getAssetToken()
     */
    @Override
    public String getAssetToken() {
        return assetToken;
    }

    public void setAssetToken(String assetToken) {
        this.assetToken = assetToken;
    }
}