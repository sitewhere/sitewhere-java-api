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