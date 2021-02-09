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
package com.sitewhere.rest.model.device.streaming;

import java.io.Serializable;

import com.sitewhere.rest.model.device.event.DeviceEvent;
import com.sitewhere.spi.device.streaming.IDeviceStreamData;

/**
 * Holds a single chunk of data from a binary stream.
 */
public class DeviceStreamData extends DeviceEvent implements IDeviceStreamData, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 7241224075838793803L;

    /** Stream id this chunk belongs to */
    private String streamId;

    /** Sequence number for ordering chunks */
    private Long sequenceNumber;

    /** Chunk data */
    private byte[] data;

    public DeviceStreamData() {
	super(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceStreamData#getStreamId()
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
     * @see com.sitewhere.spi.device.event.IDeviceStreamData#getSequenceNumber()
     */
    public Long getSequenceNumber() {
	return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceStreamData#getData()
     */
    public byte[] getData() {
	return data;
    }

    public void setData(byte[] data) {
	this.data = data;
    }
}