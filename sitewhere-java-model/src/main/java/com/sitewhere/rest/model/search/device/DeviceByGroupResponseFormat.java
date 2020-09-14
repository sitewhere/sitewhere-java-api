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

import com.sitewhere.spi.search.device.IDeviceByGroupResponseFormat;

/**
 * Default implementation of {@link IDeviceByGroupResponseFormat}.
 */
public class DeviceByGroupResponseFormat extends DeviceResponseFormat implements IDeviceByGroupResponseFormat {

    /** Indicates if deletes devices are to be included in the result */
    private Boolean includeDeleted;

    /*
     * @see com.sitewhere.spi.search.device.IDeviceByGroupResponseFormat#
     * getIncludeDeleted()
     */
    @Override
    public Boolean getIncludeDeleted() {
	return includeDeleted;
    }

    public void setIncludeDeleted(Boolean includeDeleted) {
	this.includeDeleted = includeDeleted;
    }
}
