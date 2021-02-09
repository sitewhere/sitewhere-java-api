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

import com.sitewhere.spi.device.command.DeviceMappingResult;
import com.sitewhere.spi.device.command.IDeviceMappingAckCommand;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * Default implementation of {@link IDeviceMappingAckCommand}.
 */
public class DeviceMappingAckCommand extends SystemCommand implements IDeviceMappingAckCommand {

    /** Serial version UID */
    private static final long serialVersionUID = 459571414041623952L;

    public DeviceMappingAckCommand() {
	super(SystemCommandType.DeviceMappingAck);
    }

    /** Device mapping result */
    private DeviceMappingResult result;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceMappingAckCommand#getResult()
     */
    public DeviceMappingResult getResult() {
	return result;
    }

    public void setResult(DeviceMappingResult result) {
	this.result = result;
    }
}