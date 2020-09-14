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
package com.sitewhere.rest.model.device.event.streaming;

import com.sitewhere.spi.device.event.streaming.IEventStreamAck;

/**
 * Model object for an event stream ack.
 */
public class EventStreamAck implements IEventStreamAck {

    /** Count of total events processed */
    private long processedEventCount;

    /*
     * @see com.sitewhere.spi.device.event.streaming.IEventStreamAck#
     * getProcessedEventCount()
     */
    @Override
    public long getProcessedEventCount() {
	return processedEventCount;
    }

    public void setProcessedEventCount(long processedEventCount) {
	this.processedEventCount = processedEventCount;
    }
}