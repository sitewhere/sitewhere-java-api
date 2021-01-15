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
package com.sitewhere.rest.model.device.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.rest.model.device.command.CommandParameter;
import com.sitewhere.spi.device.command.ICommandParameter;
import com.sitewhere.spi.device.command.ParameterType;
import com.sitewhere.spi.device.request.IDeviceCommandCreateRequest;

/**
 * Arguments needed to create a new device command.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceCommandCreateRequest extends PersistentEntityCreateRequest implements IDeviceCommandCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 7791276552702413783L;

    /** Token for device type */
    private String deviceTypeToken;

    /** Optional namespace */
    private String namespace;

    /** Command name */
    private String name;

    /** Command description */
    private String description;

    /** Command parameters */
    private List<CommandParameter> parameters = new ArrayList<CommandParameter>();

    /*
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#
     * getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getNamespace ()
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
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#getName()
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
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#
     * getDescription()
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
     * @see com.sitewhere.spi.device.request.IDeviceCommandCreateRequest#
     * getParameters()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ICommandParameter> getParameters() {
	return (List<ICommandParameter>) (List<? extends ICommandParameter>) parameters;
    }

    public void setParameters(List<CommandParameter> parameters) {
	this.parameters = parameters;
    }

    public static class Builder {

	/** Request being built */
	private DeviceCommandCreateRequest request = new DeviceCommandCreateRequest();

	public Builder(String deviceTypeToken, String token, String namespace, String name) {
	    request.setDeviceTypeToken(deviceTypeToken);
	    request.setToken(token);
	    request.setNamespace(namespace);
	    request.setName(name);
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withStringParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.String, required));
	    return this;
	}

	public Builder withIntParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Int64, required));
	    return this;
	}

	public Builder withDoubleParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Double, required));
	    return this;
	}

	public Builder withBooleanParameter(String name, boolean required) {
	    request.getParameters().add(new CommandParameter(name, ParameterType.Bool, required));
	    return this;
	}

	public Builder withParameter(String name, ParameterType type, boolean required) {
	    request.getParameters().add(new CommandParameter(name, type, required));
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public DeviceCommandCreateRequest build() {
	    return request;
	}
    }
}