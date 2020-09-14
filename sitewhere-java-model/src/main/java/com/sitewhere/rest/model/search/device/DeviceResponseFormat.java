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
package com.sitewhere.rest.model.search.device;

import com.sitewhere.spi.search.device.IDeviceResponseFormat;

/**
 * Default implementation of {@link IDeviceResponseFormat}.
 */
public class DeviceResponseFormat implements IDeviceResponseFormat {

    /** Indicates if device type is included */
    private Boolean includeDeviceType;

    /** Indicates if assignment is included */
    private Boolean includeAssignment;

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceResponseFormat#getIncludeDeviceType()
     */
    @Override
    public Boolean getIncludeDeviceType() {
	return includeDeviceType;
    }

    public void setIncludeDeviceType(Boolean includeDeviceType) {
	this.includeDeviceType = includeDeviceType;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IDeviceResponseFormat#getIncludeAssignment()
     */
    @Override
    public Boolean getIncludeAssignment() {
	return includeAssignment;
    }

}
