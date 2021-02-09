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

import com.sitewhere.spi.device.command.ISystemCommand;
import com.sitewhere.spi.device.command.SystemCommandType;

/**
 * Base class for system command implementations.
 */
public class SystemCommand implements ISystemCommand {

    /** Serial version UID */
    private static final long serialVersionUID = -7968782253104914645L;

    /** Command type */
    private SystemCommandType type;

    public SystemCommand(SystemCommandType type) {
	this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.ISystemCommand#getType()
     */
    public SystemCommandType getType() {
	return type;
    }

    public void setType(SystemCommandType type) {
	this.type = type;
    }
}