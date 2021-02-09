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

import java.io.Serializable;

import com.sitewhere.spi.device.command.ICommandParameter;
import com.sitewhere.spi.device.command.ParameterType;

/**
 * Model object for a command parameter.
 */
public class CommandParameter implements ICommandParameter, Serializable {

    /** For Java serialization */
    private static final long serialVersionUID = -4689464499966528051L;

    /** Command name */
    private String name;

    /** Datatype */
    private ParameterType type;

    /** Indicates whether required */
    private boolean required;

    public CommandParameter() {
    }

    public CommandParameter(String name, ParameterType type, boolean required) {
	this.name = name;
	this.type = type;
	this.required = required;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.ICommandParameter#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.ICommandParameter#getType()
     */
    @Override
    public ParameterType getType() {
	return type;
    }

    public void setType(ParameterType type) {
	this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.ICommandParameter#isRequired()
     */
    @Override
    public boolean isRequired() {
	return required;
    }

    public void setRequired(boolean required) {
	this.required = required;
    }
}