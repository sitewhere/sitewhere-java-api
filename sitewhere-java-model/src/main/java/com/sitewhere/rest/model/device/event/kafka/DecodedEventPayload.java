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
package com.sitewhere.rest.model.device.event.kafka;

import com.sitewhere.spi.device.event.kafka.IDecodedEventPayload;
import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Model object for event payload received from event sources from a tenant.
 */
public class DecodedEventPayload implements IDecodedEventPayload {

    /** Event source id */
    private String sourceId;

    /** Device token */
    private String deviceToken;

    /** Id of event originator */
    private String originator;

    /** Event create request */
    private IDeviceEventCreateRequest eventCreateRequest;

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IInboundEventPayload#
     * getSourceId()
     */
    @Override
    public String getSourceId() {
	return sourceId;
    }

    public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
    }

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IInboundEventPayload#
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
     * @see com.sitewhere.spi.microservice.kafka.payload.IInboundEventPayload#
     * getOriginator()
     */
    @Override
    public String getOriginator() {
	return originator;
    }

    public void setOriginator(String originator) {
	this.originator = originator;
    }

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IInboundEventPayload#
     * getEventCreateRequest()
     */
    @Override
    public IDeviceEventCreateRequest getEventCreateRequest() {
	return eventCreateRequest;
    }

    public void setEventCreateRequest(IDeviceEventCreateRequest eventCreateRequest) {
	this.eventCreateRequest = eventCreateRequest;
    }
}