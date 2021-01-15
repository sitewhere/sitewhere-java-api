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
package com.sitewhere.rest.model.device.element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.element.IDeviceSlot;
import com.sitewhere.spi.device.element.IDeviceUnit;

/**
 * Default implementation of {@link IDeviceUnit}.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceUnit extends DeviceElement implements IDeviceUnit, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = 5969717501161142392L;

    /** List of device slots */
    private List<DeviceSlot> deviceSlots = new ArrayList<DeviceSlot>();

    /** List of device units */
    private List<DeviceUnit> deviceUnits = new ArrayList<DeviceUnit>();

    public DeviceUnit() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.element.IDeviceUnit#getDeviceSlots()
     */
    @SuppressWarnings("unchecked")
    public List<IDeviceSlot> getDeviceSlots() {
	return (List<IDeviceSlot>) (List<? extends IDeviceSlot>) deviceSlots;
    }

    public void setDeviceSlots(List<DeviceSlot> deviceSlots) {
	this.deviceSlots = deviceSlots;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.element.IDeviceUnit#getDeviceUnits()
     */
    @SuppressWarnings("unchecked")
    public List<IDeviceUnit> getDeviceUnits() {
	return (List<IDeviceUnit>) (List<? extends IDeviceUnit>) deviceUnits;
    }

    public void setDeviceUnits(List<DeviceUnit> deviceUnits) {
	this.deviceUnits = deviceUnits;
    }
}