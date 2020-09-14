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
