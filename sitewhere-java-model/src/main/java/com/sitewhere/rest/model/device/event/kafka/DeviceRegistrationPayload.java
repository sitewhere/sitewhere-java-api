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

import com.sitewhere.spi.device.event.kafka.IDeviceRegistrationPayload;
import com.sitewhere.spi.device.event.request.IDeviceRegistrationRequest;

/**
 * Model object for device registration payload.
 */
public class DeviceRegistrationPayload implements IDeviceRegistrationPayload {

    /** Serial version UID */
    private static final long serialVersionUID = -6254913551092919151L;

    /** Event source id */
    private String sourceId;

    /** Device token */
    private String deviceToken;

    /** Id of event originator */
    private String originator;

    /** Event create request */
    private IDeviceRegistrationRequest deviceRegistrationRequest;

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IDeviceRegistrationPayload#
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
     * @see com.sitewhere.spi.microservice.kafka.payload.IDeviceRegistrationPayload#
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
     * @see com.sitewhere.spi.microservice.kafka.payload.IDeviceRegistrationPayload#
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
     * @see com.sitewhere.spi.microservice.kafka.payload.IDeviceRegistrationPayload#
     * getDeviceRegistrationRequest()
     */
    @Override
    public IDeviceRegistrationRequest getDeviceRegistrationRequest() {
	return deviceRegistrationRequest;
    }

    public void setDeviceRegistrationRequest(IDeviceRegistrationRequest deviceRegistrationRequest) {
	this.deviceRegistrationRequest = deviceRegistrationRequest;
    }
}
