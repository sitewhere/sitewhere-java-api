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
package com.sitewhere.rest.model.device.event.kafka;

import com.sitewhere.spi.device.event.IDeviceEvent;
import com.sitewhere.spi.device.event.IDeviceEventContext;
import com.sitewhere.spi.device.event.kafka.IProcessedEventPayload;

/**
 * Event payload after persistence.
 */
public class ProcessedEventPayload implements IProcessedEventPayload {

    /** Extra context */
    private IDeviceEventContext eventContext;

    /** Event */
    private IDeviceEvent event;

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IEnrichedEventPayload#
     * getEventContext()
     */
    @Override
    public IDeviceEventContext getEventContext() {
	return eventContext;
    }

    public void setEventContext(IDeviceEventContext eventContext) {
	this.eventContext = eventContext;
    }

    /*
     * @see
     * com.sitewhere.spi.microservice.kafka.payload.IEnrichedEventPayload#getEvent()
     */
    @Override
    public IDeviceEvent getEvent() {
	return event;
    }

    public void setEvent(IDeviceEvent event) {
	this.event = event;
    }
}