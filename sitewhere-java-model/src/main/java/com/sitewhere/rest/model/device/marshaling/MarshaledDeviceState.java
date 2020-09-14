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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.asset.Asset;
import com.sitewhere.rest.model.customer.Customer;
import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.DeviceAssignment;
import com.sitewhere.rest.model.device.DeviceType;
import com.sitewhere.rest.model.device.state.DeviceState;
import com.sitewhere.rest.model.device.state.RecentStateEvent;

/**
 * Extends {@link DeviceState} to support fields that can be included on REST
 * calls.
 */
@JsonInclude(Include.NON_NULL)
public class MarshaledDeviceState extends DeviceState {

    /** Serial version UID */
    private static final long serialVersionUID = -699681075037936315L;

    /** Device */
    private Device device;

    /** Device type */
    private DeviceType deviceType;

    /** Device assignment */
    private DeviceAssignment deviceAssignment;

    /** Assigned customer */
    private Customer customer;

    /** Assigned area */
    private Area area;

    /** Associated asset */
    private Asset asset;

    /** Recent state events */
    private List<RecentStateEvent> recentStatEvents;

    public Device getDevice() {
	return device;
    }

    public void setDevice(Device device) {
	this.device = device;
    }

    public DeviceType getDeviceType() {
	return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
	this.deviceType = deviceType;
    }

    public DeviceAssignment getDeviceAssignment() {
	return deviceAssignment;
    }

    public void setDeviceAssignment(DeviceAssignment deviceAssignment) {
	this.deviceAssignment = deviceAssignment;
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

    public Area getArea() {
	return area;
    }

    public void setArea(Area area) {
	this.area = area;
    }

    public Asset getAsset() {
	return asset;
    }

    public void setAsset(Asset asset) {
	this.asset = asset;
    }

    public List<RecentStateEvent> getRecentStatEvents() {
	return recentStatEvents;
    }

    public void setRecentStatEvents(List<RecentStateEvent> recentStatEvents) {
	this.recentStatEvents = recentStatEvents;
    }
}
