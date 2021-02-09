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
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceEvent;

/**
 * Model object for an event originating from a remote device.
 */
@JsonInclude(Include.NON_NULL)
public abstract class DeviceEvent extends MetadataProvider implements IDeviceEvent, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 3532362334243746084L;

    /** Unqiue id for event */
    private UUID id;

    /** Alternate (external) id for event */
    private String alternateId;

    /** Event type indicator */
    private DeviceEventType eventType;

    /** Device id */
    private UUID deviceId;

    /** Device assignment id */
    private UUID deviceAssignmentId;

    /** Customer id */
    private UUID customerId;

    /** Area id */
    private UUID areaId;

    /** Asset id */
    private UUID assetId;

    /** Date event occurred */
    private Date eventDate;

    /** Date event was received */
    private Date receivedDate;

    public DeviceEvent(DeviceEventType type) {
	this.eventType = type;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getId()
     */
    @Override
    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getAlternateId()
     */
    @Override
    public String getAlternateId() {
	return alternateId;
    }

    public void setAlternateId(String alternateId) {
	this.alternateId = alternateId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getEventType()
     */
    @Override
    public DeviceEventType getEventType() {
	return eventType;
    }

    public void setEventType(DeviceEventType eventType) {
	this.eventType = eventType;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getDeviceAssignmentId()
     */
    @Override
    public UUID getDeviceAssignmentId() {
	return deviceAssignmentId;
    }

    public void setDeviceAssignmentId(UUID deviceAssignmentId) {
	this.deviceAssignmentId = deviceAssignmentId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getCustomerId()
     */
    @Override
    public UUID getCustomerId() {
	return customerId;
    }

    public void setCustomerId(UUID customerId) {
	this.customerId = customerId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getAreaId()
     */
    @Override
    public UUID getAreaId() {
	return areaId;
    }

    public void setAreaId(UUID areaId) {
	this.areaId = areaId;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEvent#getAssetId()
     */
    @Override
    public UUID getAssetId() {
	return assetId;
    }

    public void setAssetId(UUID assetId) {
	this.assetId = assetId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEvent#getEventDate()
     */
    @Override
    public Date getEventDate() {
	return eventDate;
    }

    public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceEvent#getReceivedDate()
     */
    @Override
    public Date getReceivedDate() {
	return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
	this.receivedDate = receivedDate;
    }
}