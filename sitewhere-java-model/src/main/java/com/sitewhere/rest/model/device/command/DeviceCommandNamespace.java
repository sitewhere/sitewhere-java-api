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

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.command.IDeviceCommandNamespace;

/**
 * Used to group device commands that use the same namespace.
 */
public class DeviceCommandNamespace implements IDeviceCommandNamespace {

    /** Serial version UID */
    private static final long serialVersionUID = 4615235653915060558L;

    /** Namespace value */
    private String value;

    /** List of commands */
    private List<? extends IDeviceCommand> commands = new ArrayList<>();

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommandNamespace#getValue()
     */
    @Override
    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommandNamespace#getCommands()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<IDeviceCommand> getCommands() {
	return (List<IDeviceCommand>) (List<? extends IDeviceCommand>) commands;
    }

    public void setCommands(List<DeviceCommand> commands) {
	this.commands = commands;
    }
}