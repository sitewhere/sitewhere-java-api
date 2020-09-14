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
package com.sitewhere.rest.model.device.event.request;

import java.util.UUID;

import com.sitewhere.spi.device.event.request.IDeviceAssignmentEventCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Holds information required to create an event for a device assignment.
 */
public class DeviceAssignmentEventCreateRequest implements IDeviceAssignmentEventCreateRequest {

    /** Assignment id */
    private UUID deviceAssignmentId;

    /** Event create request */
    private IDeviceEventCreateRequest request;

    /*
     * @see
     * com.sitewhere.spi.device.event.request.IDeviceAssignmentEventCreateRequest#
     * getDeviceAssignmentId()
     */
    @Override
    public UUID getDeviceAssignmentId() {
	return deviceAssignmentId;
    }

    public void setDeviceAssignmentId(UUID deviceAssignmentId) {
	this.deviceAssignmentId = deviceAssignmentId;
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.request.IDeviceAssignmentEventCreateRequest#
     * getRequest()
     */
    @Override
    public IDeviceEventCreateRequest getRequest() {
	return request;
    }

    public void setRequest(IDeviceEventCreateRequest request) {
	this.request = request;
    }
}