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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.UUID;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.SiteWhereSystemException;
import com.sitewhere.spi.device.IDeviceType;
import com.sitewhere.spi.device.element.IDeviceElement;
import com.sitewhere.spi.device.element.IDeviceElementSchema;
import com.sitewhere.spi.device.element.IDeviceSlot;
import com.sitewhere.spi.device.element.IDeviceUnit;
import com.sitewhere.spi.error.ErrorCode;
import com.sitewhere.spi.error.ErrorLevel;

/**
 * Helper methods for common operations on {@link IDeviceType} objects.
 */
public class DeviceTypeUtils {

    /**
     * Get an {@link IDeviceSlot} given relative path in
     * {@link IDeviceElementSchema}.
     * 
     * @param deviceType
     * @param path
     * @return
     * @throws SiteWhereException
     */
    public static IDeviceSlot getDeviceSlotByPath(IDeviceType deviceType, String path) throws SiteWhereException {
	IDeviceElement match = getDeviceElementByPath(deviceType, path);
	if ((match == null) || (!(match instanceof IDeviceSlot))) {
	    throw new SiteWhereSystemException(ErrorCode.InvalidDeviceSlotPath, ErrorLevel.ERROR);
	}
	return (IDeviceSlot) match;
    }

    /**
     * Get an {@link IDeviceElement} located at the given path. Return null if not
     * found.
     * 
     * @param deviceType
     * @param path
     * @return
     */
    public static IDeviceElement getDeviceElementByPath(IDeviceType deviceType, String path) {
	if (path.startsWith("/")) {
	    path = path.substring(1);
	}
	String[] segarray = path.split("[/]");
	Queue<String> segments = new ArrayDeque<String>(Arrays.asList(segarray));
	UUID schemaId = deviceType.getDeviceElementSchemaId();
	if (schemaId == null) {
	    return null;
	}
	IDeviceUnit unit = null; // TODO: Handle schema lookup.
	while (segments.size() > 0) {
	    String segment = segments.poll();
	    if (segments.size() > 0) {
		for (IDeviceUnit nested : unit.getDeviceUnits()) {
		    if (nested.getPath().equals(segment)) {
			unit = nested;
			break;
		    }
		}
	    } else {
		for (IDeviceSlot slot : unit.getDeviceSlots()) {
		    if (slot.getPath().equals(segment)) {
			return slot;
		    }
		}
		for (IDeviceUnit nested : unit.getDeviceUnits()) {
		    if (nested.getPath().equals(segment)) {
			return nested;
		    }
		}
		return null;
	    }
	}
	return null;
    }
}