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

import com.sitewhere.spi.device.command.IRegistrationAckCommand;
import com.sitewhere.spi.device.command.RegistrationSuccessReason;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * Default implementation of {@link IRegistrationAckCommand}.
 */
public class RegistrationAckCommand extends SystemCommand implements IRegistrationAckCommand {

    /** Serial version UID */
    private static final long serialVersionUID = 1831724152286696862L;

    /** Success reason */
    private RegistrationSuccessReason reason;

    public RegistrationAckCommand() {
	super(SystemCommandType.RegistrationAck);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IRegistrationAckCommand#getReason()
     */
    public RegistrationSuccessReason getReason() {
	return reason;
    }

    public void setReason(RegistrationSuccessReason reason) {
	this.reason = reason;
    }
}