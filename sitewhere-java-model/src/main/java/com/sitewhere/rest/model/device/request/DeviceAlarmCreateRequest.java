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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.DeviceAlarmState;
import com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest;

/**
 * Fields needed to create/update a device alarm.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceAlarmCreateRequest implements IDeviceAlarmCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -5830937120265421555L;

    /** Device assignment token */
    private String deviceAssignmentToken;

    /** Alarm message */
    private String alarmMessage;

    /** Triggering event id */
    private UUID triggeringEventId;

    /** Alarm state */
    private DeviceAlarmState state;

    /** Alarm triggered date */
    private Date triggeredDate;

    /** Alarm acknowledged date */
    private Date acknowledgedDate;

    /** Alarm resolved date */
    private Date resolvedDate;

    /** Metadata */
    private Map<String, String> metadata;

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#
     * getDeviceAssignmentToken()
     */
    @Override
    public String getDeviceAssignmentToken() {
	return deviceAssignmentToken;
    }

    public void setDeviceAssignmentToken(String deviceAssignmentToken) {
	this.deviceAssignmentToken = deviceAssignmentToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#getAlarmMessage()
     */
    @Override
    public String getAlarmMessage() {
	return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
	this.alarmMessage = alarmMessage;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#
     * getTriggeringEventId()
     */
    @Override
    public UUID getTriggeringEventId() {
	return triggeringEventId;
    }

    public void setTriggeringEventId(UUID triggeringEventId) {
	this.triggeringEventId = triggeringEventId;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#getState()
     */
    @Override
    public DeviceAlarmState getState() {
	return state;
    }

    public void setState(DeviceAlarmState state) {
	this.state = state;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#getTriggeredDate()
     */
    @Override
    public Date getTriggeredDate() {
	return triggeredDate;
    }

    public void setTriggeredDate(Date triggeredDate) {
	this.triggeredDate = triggeredDate;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#
     * getAcknowledgedDate()
     */
    @Override
    public Date getAcknowledgedDate() {
	return acknowledgedDate;
    }

    public void setAcknowledgedDate(Date acknowledgedDate) {
	this.acknowledgedDate = acknowledgedDate;
    }

    /*
     * @see
     * com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#getResolvedDate()
     */
    @Override
    public Date getResolvedDate() {
	return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
	this.resolvedDate = resolvedDate;
    }

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAlarmCreateRequest#getMetadata()
     */
    @Override
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }

    public static class Builder {

	/** Request being built */
	private DeviceAlarmCreateRequest request = new DeviceAlarmCreateRequest();

	public Builder(String deviceAssignmentToken, String alarmMessage) {
	    request.setDeviceAssignmentToken(deviceAssignmentToken);
	    request.setAlarmMessage(alarmMessage);
	    request.setState(DeviceAlarmState.Triggered);
	}

	public Builder withTriggeringEventId(UUID eventId) {
	    request.setTriggeringEventId(eventId);
	    return this;
	}

	public Builder withTriggeredState() {
	    request.setState(DeviceAlarmState.Triggered);
	    return this;
	}

	public Builder withAcknowledgedState() {
	    request.setState(DeviceAlarmState.Acknowledged);
	    return this;
	}

	public Builder withResolvedState() {
	    request.setState(DeviceAlarmState.Resolved);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceAlarmCreateRequest build() {
	    return request;
	}
    }
}
