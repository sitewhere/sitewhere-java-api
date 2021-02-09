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
package com.sitewhere.rest.model.device.event.request;

import java.util.UUID;

import com.sitewhere.spi.device.event.request.ISendDeviceStreamDataRequest;

/**
 * Implementation of {@link ISendDeviceStreamDataRequest}.
 */
public class SendDeviceStreamDataRequest implements ISendDeviceStreamDataRequest {

    /** Stream id */
    private UUID streamId;

    /** Sequence number */
    private long sequenceNumber;

    /*
     * @see com.sitewhere.spi.device.event.request.ISendDeviceStreamDataRequest#
     * getStreamId()
     */
    @Override
    public UUID getStreamId() {
	return streamId;
    }

    public void setStreamId(UUID streamId) {
	this.streamId = streamId;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.ISendDeviceStreamDataRequest#
     * getSequenceNumber()
     */
    @Override
    public long getSequenceNumber() {
	return sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }
}