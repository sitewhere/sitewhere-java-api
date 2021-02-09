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
package com.sitewhere.rest.model.device.communication;

/**
 * Used for marshaling device request data to JSON.
 */
public class DeviceRequest {

    /** Device token the request applies to */
    private String deviceToken;

    /** Originating invocation if available */
    private String originator;

    /** Request type */
    private Type type;

    /** Event create request */
    private Object request;

    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    public String getOriginator() {
	return originator;
    }

    public void setOriginator(String originator) {
	this.originator = originator;
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public Object getRequest() {
	return request;
    }

    public void setRequest(Object request) {
	this.request = request;
    }

    /**
     * Enumerates types of expected requests.
     */
    public static enum Type {

	/** Register a device */
	RegisterDevice,

	/** Send a device location event */
	DeviceLocation,

	/** Send a device alert event */
	DeviceAlert,

	/** Send a device measurement event */
	DeviceMeasurement,

	/** Send a device steam create request */
	DeviceStream,

	/** Send a device stream data event */
	DeviceStreamData,

	/** Send a command acknowledgement */
	Acknowledge
    }
}