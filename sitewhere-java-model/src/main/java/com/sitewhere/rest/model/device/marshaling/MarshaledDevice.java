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
package com.sitewhere.rest.model.device.marshaling;

import java.util.List;

import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceType;

/**
 * Extends {@link Device} to support fields that can be included on REST calls.
 */
public class MarshaledDevice extends Device {

    /** Serial version UID */
    private static final long serialVersionUID = -7249138366647616811L;

    /** Device type */
    private DeviceType deviceType;

    /** Current device assignment */
    private List<MarshaledDeviceAssignment> activeDeviceAssignments;

    public DeviceType getDeviceType() {
	return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
	this.deviceType = deviceType;
    }

    public List<MarshaledDeviceAssignment> getActiveDeviceAssignments() {
	return activeDeviceAssignments;
    }

    public void setActiveDeviceAssignments(List<MarshaledDeviceAssignment> activeDeviceAssignments) {
	this.activeDeviceAssignments = activeDeviceAssignments;
    }
}