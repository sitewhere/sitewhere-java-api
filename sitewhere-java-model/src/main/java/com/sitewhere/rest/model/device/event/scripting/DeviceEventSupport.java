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
package com.sitewhere.rest.model.device.event.scripting;

import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceAlert;
import com.sitewhere.spi.device.event.IDeviceEvent;

/**
 * Provides support for common operations on device events in scripting
 * operations.
 */
public class DeviceEventSupport {

    /** Device assignment */
    private IDeviceAssignment deviceAssignment;

    /** Wrapped event */
    private IDeviceEvent event;

    public DeviceEventSupport(IDeviceAssignment deviceAssignment, IDeviceEvent event) {
	this.deviceAssignment = deviceAssignment;
	this.event = event;
    }

    /**
     * Indicates a location event.
     * 
     * @return
     */
    public boolean isLocation() {
	return event.getEventType() == DeviceEventType.Location;
    }

    /**
     * Indicates a measurement event.
     * 
     * @return
     */
    public boolean isMeasurement() {
	return event.getEventType() == DeviceEventType.Measurement;
    }

    /**
     * Indicates a command invocation event.
     * 
     * @return
     */
    public boolean isCommandInvocation() {
	return event.getEventType() == DeviceEventType.CommandInvocation;
    }

    /**
     * Indicates a command response event.
     * 
     * @return
     */
    public boolean isCommandResponse() {
	return event.getEventType() == DeviceEventType.CommandResponse;
    }

    /**
     * Returns true if event is an alert.
     * 
     * @return
     */
    public boolean isAlert() {
	return event.getEventType() == DeviceEventType.Alert;
    }

    /**
     * Returns true if event is an alert and has the given type.
     * 
     * @param type
     * @return
     */
    public boolean isAlertOfType(String type) {
	return (isAlert() && ((IDeviceAlert) event).getType().equals(type));
    }

    public IDeviceAssignment getDeviceAssignment() {
	return deviceAssignment;
    }

    public void setDeviceAssignment(IDeviceAssignment deviceAssignment) {
	this.deviceAssignment = deviceAssignment;
    }

    public IDeviceEvent data() {
	return event;
    }

    public IDeviceEvent getData() {
	return event;
    }
}