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
package com.sitewhere.rest.model.device.event;

import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceStateChange;

/**
 * Model object for a state change reported by a remote device.
 */
public class DeviceStateChange extends DeviceEvent implements IDeviceStateChange {

    /** Serial version UID */
    private static final long serialVersionUID = 7635022335783458408L;

    /** State change category */
    private String attribute;

    /** State change type */
    private String type;

    /** Previous or expected state */
    private String previousState;

    /** New state */
    private String newState;

    public DeviceStateChange() {
	super(DeviceEventType.StateChange);
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceStateChange#getAttribute()
     */
    @Override
    public String getAttribute() {
	return attribute;
    }

    public void setAttribute(String attribute) {
	this.attribute = attribute;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceStateChange#getType()
     */
    @Override
    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceStateChange#getPreviousState()
     */
    @Override
    public String getPreviousState() {
	return previousState;
    }

    public void setPreviousState(String previousState) {
	this.previousState = previousState;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceStateChange#getNewState()
     */
    @Override
    public String getNewState() {
	return newState;
    }

    public void setNewState(String newState) {
	this.newState = newState;
    }
}