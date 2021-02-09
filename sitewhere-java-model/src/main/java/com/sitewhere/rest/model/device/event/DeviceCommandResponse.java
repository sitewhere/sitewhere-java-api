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
package com.sitewhere.rest.model.device.event;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceCommandResponse;

/**
 * Implementation of {@link IDeviceCommandResponse}.
 */
@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class DeviceCommandResponse extends DeviceEvent implements IDeviceCommandResponse, Serializable {

    /** For Java serialization */
    private static final long serialVersionUID = 4448837178695704510L;

    /** Event id that generated response */
    private UUID originatingEventId;

    /** Event sent in response */
    private UUID responseEventId;

    /** Data sent for response */
    private String response;

    public DeviceCommandResponse() {
	super(DeviceEventType.CommandResponse);
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.IDeviceCommandResponse#getOriginatingEventId()
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
     * com.sitewhere.spi.device.event.IDeviceCommandResponse#getResponseEventId()
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
     * @see com.sitewhere.spi.device.event.IDeviceCommandResponse#getResponse()
     */
    @Override
    public String getResponse() {
	return response;
    }

    public void setResponse(String response) {
	this.response = response;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static DeviceCommandResponse copy(IDeviceCommandResponse input) throws SiteWhereException {
	DeviceCommandResponse result = new DeviceCommandResponse();
	DeviceEvent.copy(input, result);
	result.setOriginatingEventId(input.getOriginatingEventId());
	result.setResponseEventId(input.getResponseEventId());
	result.setResponse(input.getResponse());
	return result;
    }
}