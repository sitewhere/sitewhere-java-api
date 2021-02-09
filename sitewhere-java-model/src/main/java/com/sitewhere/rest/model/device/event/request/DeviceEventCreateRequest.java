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

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sitewhere.rest.model.device.event.DeviceEvent;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Holds common fields for creating {@link DeviceEvent} subclasses.
 */
public class DeviceEventCreateRequest implements IDeviceEventCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = -8906177904822194407L;

    /** Alternate (external) id for event */
    private String alternateId;

    /** Event type indicator */
    private DeviceEventType eventType;

    /** Date event occurred */
    private Date eventDate;

    /** Indicates whether device assignment state should be updated */
    private boolean updateState = false;

    /** Metadata values */
    private Map<String, String> metadata;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest#
     * getAlternateId()
     */
    @Override
    public String getAlternateId() {
	return alternateId;
    }

    public void setAlternateId(String alternateId) {
	this.alternateId = alternateId;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest#
     * getEventType()
     */
    @Override
    public DeviceEventType getEventType() {
	return eventType;
    }

    public void setEventType(DeviceEventType eventType) {
	this.eventType = eventType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceEventCreateRequest#getEventDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getEventDate() {
	return eventDate;
    }

    public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest#
     * isUpdateState()
     */
    @Override
    public boolean isUpdateState() {
	return updateState;
    }

    public void setUpdateState(boolean updateState) {
	this.updateState = updateState;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest#
     * getMetadata()
     */
    @Override
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }

    /**
     * Uses builder pattern to create device event requests.
     */
    public abstract static class Builder<T extends DeviceEventCreateRequest> {

	// Request type implemented in subclasses.
	public abstract T getRequest();

	// Build the create request.
	public abstract T build();

	public Builder<T> on(Date date) {
	    getRequest().setEventDate(date);
	    return this;
	}

	public Builder<T> trackState() {
	    getRequest().setUpdateState(true);
	    return this;
	}
    }
}