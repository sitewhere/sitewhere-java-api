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

import java.io.Serializable;

import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.request.IDeviceStateChangeCreateRequest;

/**
 * Represents a change in state for a device. This may be a statement of the
 * current state (i.e. a piece of hardware is unavailable) or a request for
 * change of system state (i.e the device requests registration in the system).
 */
public class DeviceStateChangeCreateRequest extends DeviceEventCreateRequest
	implements IDeviceStateChangeCreateRequest, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -2789928889465310950L;

    /** Attribute being updated */
    private String attribute;

    /** State change type */
    private String type;

    /** Previous or expected state */
    private String previousState;

    /** New state */
    private String newState;

    public DeviceStateChangeCreateRequest() {
	setEventType(DeviceEventType.StateChange);
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceStateChangeCreateRequest#
     * getAttribute()
     */
    @Override
    public String getAttribute() {
	return attribute;
    }

    public void setAttribute(String attribute) {
	this.attribute = attribute;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceStateChangeCreateRequest#
     * getType()
     */
    @Override
    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStateChangeRequest#
     * getPreviousState()
     */
    @Override
    public String getPreviousState() {
	return previousState;
    }

    public void setPreviousState(String previousState) {
	this.previousState = previousState;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStateChangeRequest#
     * getNewState()
     */
    @Override
    public String getNewState() {
	return newState;
    }

    public void setNewState(String newState) {
	this.newState = newState;
    }
}