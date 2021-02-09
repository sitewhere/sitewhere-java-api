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
package com.sitewhere.rest.model.device.support;

import com.sitewhere.rest.model.common.Location;

/**
 * Entry used in InterpolatedAssignmentHistory.
 */
public class DeviceAssignmentHistoryEntry {

    /** Time slot (in ms.) */
    private long timeSlot;

    /** Location information */
    private Location location;

    public long getTimeSlot() {
	return timeSlot;
    }

    public void setTimeSlot(long timeSlot) {
	this.timeSlot = timeSlot;
    }

    public Location getLocation() {
	return location;
    }

    public void setLocation(Location location) {
	this.location = location;
    }
}