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

import java.util.HashMap;
import java.util.Map;

import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.command.IDeviceCommandExecution;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;

/**
 * Default implementation of the {@link IDeviceCommandExecution} interface.
 */
public class DeviceCommandExecution implements IDeviceCommandExecution {

    /** Serial version UID */
    private static final long serialVersionUID = 2511870502556301534L;

    /** Command being executed */
    private IDeviceCommand command;

    /** Command invocation details */
    private IDeviceCommandInvocation invocation;

    /** Map of parameter names to values calculated from invocation */
    private Map<String, Object> parameters = new HashMap<String, Object>();

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommandExecution#getCommand()
     */
    public IDeviceCommand getCommand() {
	return command;
    }

    public void setCommand(IDeviceCommand command) {
	this.command = command;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommandExecution#getInvocation()
     */
    public IDeviceCommandInvocation getInvocation() {
	return invocation;
    }

    public void setInvocation(IDeviceCommandInvocation invocation) {
	this.invocation = invocation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommandExecution#getParameters()
     */
    public Map<String, Object> getParameters() {
	return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
	this.parameters = parameters;
    }
}