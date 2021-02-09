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
package com.sitewhere.rest.model.device.command;

import java.util.UUID;

import com.sitewhere.spi.device.command.DeviceStreamStatus;
import com.sitewhere.spi.device.command.IDeviceStreamAckCommand;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * Command sent to a device to indicate status of creating a device stream.
 */
public class DeviceStreamAckCommand extends SystemCommand implements IDeviceStreamAckCommand {

    /** Serial version UID */
    private static final long serialVersionUID = -6363023316760034867L;

    /** Id of stream being created */
    private UUID streamId;

    /** Status of creating device stream */
    private DeviceStreamStatus status;

    public DeviceStreamAckCommand() {
	super(SystemCommandType.DeviceStreamAck);
    }

    /*
     * @see com.sitewhere.spi.device.command.IDeviceStreamAckCommand#getStreamId()
     */
    @Override
    public UUID getStreamId() {
	return streamId;
    }

    public void setStreamId(UUID streamId) {
	this.streamId = streamId;
    }

    /*
     * @see com.sitewhere.spi.device.command.IDeviceStreamAckCommand#getStatus()
     */
    @Override
    public DeviceStreamStatus getStatus() {
	return status;
    }

    public void setStatus(DeviceStreamStatus status) {
	this.status = status;
    }
}