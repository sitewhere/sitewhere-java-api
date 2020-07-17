/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.marshaling;

import com.sitewhere.rest.model.asset.marshaling.MarshaledAsset;
import com.sitewhere.rest.model.device.DeviceAssignment;

/**
 * Extends {@link DeviceAssignment} to support fields that can be included on
 * REST calls.
 */
public class MarshaledDeviceAssignment extends DeviceAssignment {

    /** Serial version UID */
    private static final long serialVersionUID = -6149550465354186892L;

    /** Device being assigned */
    private MarshaledDevice device;

    /** Assigned customer */
    private MarshaledCustomer customer;

    /** Assigned area */
    private MarshaledArea area;

    /** Associated asset */
    private MarshaledAsset asset;

    public MarshaledDevice getDevice() {
	return device;
    }

    public void setDevice(MarshaledDevice device) {
	this.device = device;
    }

    public MarshaledCustomer getCustomer() {
	return customer;
    }

    public void setCustomer(MarshaledCustomer customer) {
	this.customer = customer;
    }

    public MarshaledArea getArea() {
	return area;
    }

    public void setArea(MarshaledArea area) {
	this.area = area;
    }

    public MarshaledAsset getAsset() {
	return asset;
    }

    public void setAsset(MarshaledAsset asset) {
	this.asset = asset;
    }
}