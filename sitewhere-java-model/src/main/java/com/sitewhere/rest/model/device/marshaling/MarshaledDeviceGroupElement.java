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

import com.sitewhere.rest.model.device.Device;
import com.sitewhere.rest.model.device.group.DeviceGroup;
import com.sitewhere.rest.model.device.group.DeviceGroupElement;

/**
 * Extends {@link DeviceGroupElement} to support fields that can be included on
 * REST calls.
 */
public class MarshaledDeviceGroupElement extends DeviceGroupElement {

    /** Serial version UID */
    private static final long serialVersionUID = 4423004146092498880L;

    /** Referenced device */
    private Device device;

    /** Referenced device group */
    private DeviceGroup deviceGroup;

    public Device getDevice() {
	return device;
    }

    public void setDevice(Device device) {
	this.device = device;
    }

    public DeviceGroup getDeviceGroup() {
	return deviceGroup;
    }

    public void setDeviceGroup(DeviceGroup deviceGroup) {
	this.deviceGroup = deviceGroup;
    }
}