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
import java.util.UUID;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.command.ICommandParameter;
import com.sitewhere.spi.device.command.IDeviceCommand;

/**
 * Model object for a command that can be invoked on a device.
 */
public class DeviceCommand extends PersistentEntity implements IDeviceCommand {

    /** For Java serialization */
    private static final long serialVersionUID = -9098150828821813365L;

    /** Unique id for parent specification */
    private UUID deviceTypeId;

    /** Command namespace */
    private String namespace;

    /** Command name */
    private String name;

    /** Command description */
    private String description;

    /** Parameter list */
    private List<CommandParameter> parameters = new ArrayList<CommandParameter>();

    /*
     * @see com.sitewhere.spi.device.command.IDeviceCommand#getDeviceTypeId()
     */
    @Override
    public UUID getDeviceTypeId() {
	return deviceTypeId;
    }

    public void setDeviceTypeId(UUID deviceTypeId) {
	this.deviceTypeId = deviceTypeId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommand#getNamespace()
     */
    @Override
    public String getNamespace() {
	return namespace;
    }

    public void setNamespace(String namespace) {
	this.namespace = namespace;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommand#getName()
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
     * @see com.sitewhere.spi.device.command.IDeviceCommand#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.command.IDeviceCommand#getParameters()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<ICommandParameter> getParameters() {
	return (List<ICommandParameter>) (List<? extends ICommandParameter>) parameters;
    }

    public void setParameters(List<CommandParameter> parameters) {
	this.parameters = parameters;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static DeviceCommand copy(IDeviceCommand input) throws SiteWhereException {
	DeviceCommand result = new DeviceCommand();
	PersistentEntity.copy(input, result);
	result.setId(input.getId());
	result.setToken(input.getToken());
	result.setDeviceTypeId(input.getDeviceTypeId());
	result.setName(input.getName());
	result.setNamespace(input.getNamespace());
	result.setDescription(input.getDescription());
	for (ICommandParameter inparam : input.getParameters()) {
	    CommandParameter param = new CommandParameter();
	    param.setName(inparam.getName());
	    param.setType(inparam.getType());
	    param.setRequired(inparam.isRequired());
	    result.getParameters().add(param);
	}
	return result;
    }
}