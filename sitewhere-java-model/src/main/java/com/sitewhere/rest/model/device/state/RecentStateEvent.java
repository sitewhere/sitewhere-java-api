/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.state;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.state.IRecentStateEvent;

/**
 * Contains information about a recent event associated with device state.
 */
public class RecentStateEvent implements IRecentStateEvent {

    /** Reference to event id */
    private UUID id;

    /** Device state id */
    private UUID deviceStateId;

    /** Event type */
    private DeviceEventType eventType;

    /** Event classifier */
    private String classifier;

    /** Most recent value */
    private String value;

    /** Event date */
    private Date eventDate;

    /** Reference to event id */
    private UUID eventId;

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getId()
     */
    @Override
    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getDeviceStateId()
     */
    @Override
    public UUID getDeviceStateId() {
	return deviceStateId;
    }

    public void setDeviceStateId(UUID deviceStateId) {
	this.deviceStateId = deviceStateId;
    }

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getEventType()
     */
    @Override
    public DeviceEventType getEventType() {
	return eventType;
    }

    public void setEventType(DeviceEventType eventType) {
	this.eventType = eventType;
    }

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getClassifier()
     */
    @Override
    public String getClassifier() {
	return classifier;
    }

    public void setClassifier(String classifier) {
	this.classifier = classifier;
    }

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getValue()
     */
    @Override
    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    /*
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getEventDate()
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
     * @see com.sitewhere.spi.device.state.IRecentStateEvent#getEventId()
     */
    @Override
    public UUID getEventId() {
	return eventId;
    }

    public void setEventId(UUID eventId) {
	this.eventId = eventId;
    }
}
