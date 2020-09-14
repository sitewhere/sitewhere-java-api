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
package com.sitewhere.rest.model.device.command;

import java.util.UUID;

import com.sitewhere.spi.device.command.ISendDeviceStreamDataCommand;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * System command that sends a chunk of device stream data to a device.
 */
public class SendDeviceStreamDataCommand extends SystemCommand implements ISendDeviceStreamDataCommand {

    /** Serial version UID */
    private static final long serialVersionUID = -5372263771806975660L;

    /** Device token */
    private String deviceToken;

    /** Stream id */
    private UUID streamId;

    /** Sequence number */
    private long sequenceNumber;

    /** Data */
    private byte[] data;

    public SendDeviceStreamDataCommand() {
	super(SystemCommandType.SendDeviceStreamData);
    }

    /*
     * @see
     * com.sitewhere.spi.device.command.ISendDeviceStreamDataCommand#getDeviceToken(
     * )
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * @see
     * com.sitewhere.spi.device.command.ISendDeviceStreamDataCommand#getStreamId()
     */
    @Override
    public UUID getStreamId() {
	return streamId;
    }

    public void setStreamId(UUID streamId) {
	this.streamId = streamId;
    }

    /*
     * @see com.sitewhere.spi.device.command.ISendDeviceStreamDataCommand#
     * getSequenceNumber()
     */
    @Override
    public long getSequenceNumber() {
	return sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }

    /*
     * @see com.sitewhere.spi.device.command.ISendDeviceStreamDataCommand#getData()
     */
    @Override
    public byte[] getData() {
	return data;
    }

    public void setData(byte[] data) {
	this.data = data;
    }
}