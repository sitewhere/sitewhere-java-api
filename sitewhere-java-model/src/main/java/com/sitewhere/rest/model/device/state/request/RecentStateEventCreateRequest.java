/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.state.request;

import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.device.state.request.IRecentStateEventCreateRequest;

/**
 * Provides information required to create/update a recent state event.
 */
public class RecentStateEventCreateRequest implements IRecentStateEventCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 6632948781587033978L;

    /** Device state id */
    private UUID deviceStateId;

    /** Event id */
    private UUID eventId;

    /** Event date */
    private Date eventDate;

    /*
     * @see com.sitewhere.spi.device.state.request.IRecentStateEventCreateRequest#
     * getDeviceStateId()
     */
    @Override
    public UUID getDeviceStateId() {
	return deviceStateId;
    }

    public void setDeviceStateId(UUID deviceStateId) {
	this.deviceStateId = deviceStateId;
    }

    /*
     * @see com.sitewhere.spi.device.state.request.IRecentStateEventCreateRequest#
     * getEventId()
     */
    @Override
    public UUID getEventId() {
	return eventId;
    }

    public void setEventId(UUID eventId) {
	this.eventId = eventId;
    }

    /*
     * @see com.sitewhere.spi.device.state.request.IRecentStateEventCreateRequest#
     * getEventDate()
     */
    @Override
    public Date getEventDate() {
	return eventDate;
    }

    public void setEventDate(Date eventDate) {
	this.eventDate = eventDate;
    }
}
