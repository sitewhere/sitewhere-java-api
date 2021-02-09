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
package com.sitewhere.rest.model.device.event;

import java.io.Serializable;
import java.util.UUID;

import com.sitewhere.spi.device.event.IDeviceEvent;
import com.sitewhere.spi.device.event.IDeviceEventOriginator;

/**
 * Default implementation of {@link IDeviceEventOriginator}. This object is used
 * to provide a strongly-typed argument in interactions with device agents that
 * use Java introspection to find the right method to invoke.
 */
public class DeviceEventOriginator implements IDeviceEventOriginator, Serializable {

    /** Used for Java serialization */
    private static final long serialVersionUID = -5674524224174870647L;

    /** Originating event id */
    private UUID eventId;

    public DeviceEventOriginator(IDeviceEvent event) {
	this.eventId = event.getId();
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceEventOriginator#getEventId()
     */
    @Override
    public UUID getEventId() {
	return eventId;
    }

    public void setEventId(UUID eventId) {
	this.eventId = eventId;
    }
}