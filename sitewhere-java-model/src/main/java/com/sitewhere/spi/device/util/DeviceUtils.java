/**
 * Copyright © 2014-2021 The SiteWhere Authors
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
package com.sitewhere.spi.device.util;

import com.sitewhere.spi.device.IDevice;
import com.sitewhere.spi.device.IDeviceElementMapping;

/**
 * Helper methods for common operations on {@link IDevice} objects.
 */
public class DeviceUtils {

    /**
     * Find {@link IDeviceElementMapping} for the given nested device token.
     * 
     * @param device
     * @param nestedDeviceToken
     * @return
     */
    public static IDeviceElementMapping findMappingFor(IDevice device, String nestedDeviceToken) {
	if (device.getDeviceElementMappings() != null) {
	    for (IDeviceElementMapping mapping : device.getDeviceElementMappings()) {
		if (mapping.getDeviceToken().equals(nestedDeviceToken)) {
		    return mapping;
		}
	    }
	}
	return null;
    }
}