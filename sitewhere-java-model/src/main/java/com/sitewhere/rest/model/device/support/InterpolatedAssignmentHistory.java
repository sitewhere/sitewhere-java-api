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
package com.sitewhere.rest.model.device.support;

import java.util.List;

/**
 * Holds interpolated locations for an assignment in one-minute intervals.
 */
public class InterpolatedAssignmentHistory {

    /** Device assignment token */
    private String deviceAssignmentToken;

    /** List of history entries */
    private List<DeviceAssignmentHistoryEntry> slots;

    public String getDeviceAssignmentToken() {
	return deviceAssignmentToken;
    }

    public void setDeviceAssignmentToken(String deviceAssignmentToken) {
	this.deviceAssignmentToken = deviceAssignmentToken;
    }

    public List<DeviceAssignmentHistoryEntry> getSlots() {
	return slots;
    }

    public void setSlots(List<DeviceAssignmentHistoryEntry> slots) {
	this.slots = slots;
    }
}