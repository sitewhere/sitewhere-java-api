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

import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.Zone;
import com.sitewhere.rest.model.device.DeviceAssignment;

/**
 * Extends {@link Area} to support fields that can be included on REST calls.
 */
public class MarshaledArea extends Area {

    /** Serial version UID */
    private static final long serialVersionUID = 129857679204159756L;

    /** Area type */
    private AreaType areaType;

    /** Parent area information */
    private Area parentArea;

    /** List of assignments for area */
    private List<DeviceAssignment> deviceAssignments;

    /** List of zones for site */
    private List<Zone> zones;

    public AreaType getAreaType() {
	return areaType;
    }

    public void setAreaType(AreaType areaType) {
	this.areaType = areaType;
    }

    public Area getParentArea() {
	return parentArea;
    }

    public void setParentArea(Area parentArea) {
	this.parentArea = parentArea;
    }

    public List<DeviceAssignment> getDeviceAssignments() {
	return deviceAssignments;
    }

    public void setDeviceAssignments(List<DeviceAssignment> deviceAssignments) {
	this.deviceAssignments = deviceAssignments;
    }

    public List<Zone> getZones() {
	return zones;
    }

    public void setZones(List<Zone> zones) {
	this.zones = zones;
    }
}