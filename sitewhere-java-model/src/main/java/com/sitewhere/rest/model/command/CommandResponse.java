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
package com.sitewhere.rest.model.command;

import com.sitewhere.spi.command.CommandResult;
import com.sitewhere.spi.command.ICommandResponse;

/**
 * Model object for a command response.
 */
public class CommandResponse implements ICommandResponse {

    /** Serial version UID */
    private static final long serialVersionUID = 2189097956869085792L;

    /** Command result */
    private CommandResult result;

    /** Detail message */
    private String message;

    public CommandResponse() {
    }

    public CommandResponse(CommandResult result, String message) {
	this.result = result;
	this.message = message;
    }

    public CommandResult getResult() {
	return result;
    }

    public void setResult(CommandResult result) {
	this.result = result;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * Copy an SPI object to one that can marshaled.
     * 
     * @param input
     * @return
     */
    public static CommandResponse copy(ICommandResponse input) {
	CommandResponse response = new CommandResponse();
	response.setMessage(input.getMessage());
	response.setResult(input.getResult());
	return response;
    }
}