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
package com.sitewhere.rest.model.device.request;

import java.util.List;

import com.sitewhere.spi.device.request.IDeviceAssignmentBulkRequest;

/**
 * Contains information about a request that applies to multiple device
 * assignments.
 */
public class DeviceAssignmentBulkRequest implements IDeviceAssignmentBulkRequest {

    /** Device assignment tokens */
    private List<String> deviceAssignmentTokens;

    /*
     * @see com.sitewhere.spi.device.request.IDeviceAssignmentBulkRequest#
     * getDeviceAssignmentTokens()
     */
    @Override
    public List<String> getDeviceAssignmentTokens() {
	return deviceAssignmentTokens;
    }

    public void setDeviceAssignmentTokens(List<String> deviceAssignmentTokens) {
	this.deviceAssignmentTokens = deviceAssignmentTokens;
    }
}
