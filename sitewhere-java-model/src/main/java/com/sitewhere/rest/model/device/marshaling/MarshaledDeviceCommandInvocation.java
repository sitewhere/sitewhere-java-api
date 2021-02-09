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
package com.sitewhere.rest.model.device.marshaling;

import com.sitewhere.rest.model.device.command.DeviceCommand;
import com.sitewhere.rest.model.device.event.DeviceCommandInvocation;

/**
 * Extends {@link DeviceCommandInvocation} to support fields that can be
 * included on REST calls.
 */
public class MarshaledDeviceCommandInvocation extends DeviceCommandInvocation {

    /** Serial version UID */
    private static final long serialVersionUID = 2111536821151803479L;

    /** Command that was invoked */
    private DeviceCommand command;

    /** HTML representation of invocation */
    private String asHtml;

    public DeviceCommand getCommand() {
	return command;
    }

    public void setCommand(DeviceCommand command) {
	this.command = command;
    }

    public String getAsHtml() {
	return asHtml;
    }

    public void setAsHtml(String asHtml) {
	this.asHtml = asHtml;
    }
}