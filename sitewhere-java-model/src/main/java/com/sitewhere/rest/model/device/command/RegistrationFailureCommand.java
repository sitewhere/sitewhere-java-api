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

import com.sitewhere.spi.device.command.IRegistrationFailureCommand;
import com.sitewhere.spi.device.command.RegistrationFailureReason;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * Default implementation of {@link IRegistrationFailureCommand}.
 */
public class RegistrationFailureCommand extends SystemCommand implements IRegistrationFailureCommand {

    /** Serial version UID */
    private static final long serialVersionUID = -2141636538202966306L;

    /** Failure reason */
    private RegistrationFailureReason reason;

    /** Error message */
    private String errorMessage;

    public RegistrationFailureCommand() {
	super(SystemCommandType.RegistrationFailure);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IRegistrationFailureCommand#getReason()
     */
    public RegistrationFailureReason getReason() {
	return reason;
    }

    public void setReason(RegistrationFailureReason reason) {
	this.reason = reason;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IRegistrationFailureCommand#
     * getErrorMessage()
     */
    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }
}