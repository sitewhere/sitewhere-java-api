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
package com.sitewhere.rest.model.device.streaming.request;

import java.io.Serializable;

import com.sitewhere.rest.model.device.event.request.DeviceEventCreateRequest;
import com.sitewhere.rest.model.device.streaming.DeviceStreamData;
import com.sitewhere.spi.device.streaming.request.IDeviceStreamDataCreateRequest;

/**
 * Model object used to create a new {@link DeviceStreamData} via REST APIs.
 */
public class DeviceStreamDataCreateRequest extends DeviceEventCreateRequest
	implements IDeviceStreamDataCreateRequest, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = -8175812734171141445L;

    /** Stream id */
    private String streamId;

    /** Sequence number for ordering chunks */
    private long sequenceNumber;

    /** Chunk data */
    private byte[] data;

    public DeviceStreamDataCreateRequest() {
	setEventType(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStreamDataCreateRequest#
     * getStreamId()
     */
    public String getStreamId() {
	return streamId;
    }

    public void setStreamId(String streamId) {
	this.streamId = streamId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStreamDataCreateRequest#
     * getSequenceNumber ()
     */
    public long getSequenceNumber() {
	return sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStreamDataCreateRequest#
     * getData()
     */
    public byte[] getData() {
	return data;
    }

    public void setData(byte[] data) {
	this.data = data;
    }
}