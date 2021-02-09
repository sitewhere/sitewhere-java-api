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

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceCommandResponse;
import com.sitewhere.spi.device.event.request.IDeviceCommandResponseCreateRequest;

/**
 * Model object used to create a new {@link IDeviceCommandResponse} via REST
 * APIs.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceCommandResponseCreateRequest extends DeviceEventCreateRequest
	implements IDeviceCommandResponseCreateRequest, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -9170930846188888841L;

    /** Event id that generated response */
    private UUID originatingEventId;

    /** Event sent in response */
    private UUID responseEventId;

    /** Data sent for response */
    private String response;

    public DeviceCommandResponseCreateRequest() {
	setEventType(DeviceEventType.CommandResponse);
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.request.IDeviceCommandResponseCreateRequest#
     * getOriginatingEventId()
     */
    @Override
    public UUID getOriginatingEventId() {
	return originatingEventId;
    }

    public void setOriginatingEventId(UUID originatingEventId) {
	this.originatingEventId = originatingEventId;
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.request.IDeviceCommandResponseCreateRequest#
     * getResponseEventId()
     */
    @Override
    public UUID getResponseEventId() {
	return responseEventId;
    }

    public void setResponseEventId(UUID responseEventId) {
	this.responseEventId = responseEventId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.
     * IDeviceCommandResponseCreateRequest#getResponse ()
     */
    @Override
    public String getResponse() {
	return response;
    }

    public void setResponse(String response) {
	this.response = response;
    }
}