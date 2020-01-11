/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
