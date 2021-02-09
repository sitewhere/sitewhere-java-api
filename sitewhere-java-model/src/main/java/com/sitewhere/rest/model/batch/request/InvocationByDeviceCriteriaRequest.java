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
package com.sitewhere.rest.model.batch.request;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.request.IInvocationByDeviceCriteriaRequest;

/**
 * Request for creating command invocations for devices which match the given
 * criteria.
 */
@JsonInclude(Include.NON_NULL)
public class InvocationByDeviceCriteriaRequest extends PersistentEntityCreateRequest
	implements IInvocationByDeviceCriteriaRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = -7139262971572322676L;

    /** Device type token to limit by */
    private String deviceTypeToken;

    /** Token for command to execute */
    private String commandToken;

    /** Map of parameter values */
    private Map<String, String> parameterValues = new HashMap<String, String>();

    /*
     * @see
     * com.sitewhere.spi.batch.request.invocation.IInvocationByDeviceCriteriaRequest
     * #getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * @see
     * com.sitewhere.spi.batch.request.invocation.IInvocationByDeviceCriteriaRequest
     * #getCommandToken()
     */
    @Override
    public String getCommandToken() {
	return commandToken;
    }

    public void setCommandToken(String commandToken) {
	this.commandToken = commandToken;
    }

    /*
     * @see
     * com.sitewhere.spi.batch.request.invocation.IInvocationByDeviceCriteriaRequest
     * #getParameterValues()
     */
    @Override
    public Map<String, String> getParameterValues() {
	return parameterValues;
    }

    public void setParameterValues(Map<String, String> parameterValues) {
	this.parameterValues = parameterValues;
    }

    public static class Builder {

	/** Build object */
	private InvocationByDeviceCriteriaRequest build;

	private Builder() {
	    super();
	    this.build = new InvocationByDeviceCriteriaRequest();
	    withToken(UUID.randomUUID().toString());
	}

	public Builder withToken(String token) {
	    this.build.setToken(token);
	    return this;
	}

	public Builder withDeviceTypeToken(String deviceTypeToken) {
	    this.build.setDeviceTypeToken(deviceTypeToken);
	    return this;
	}

	public Builder withCommandToken(String commandToken) {
	    this.build.setCommandToken(commandToken);
	    return this;
	}

	public Builder withParameter(String name, String value) {
	    this.build.getParameterValues().put(name, value);
	    return this;
	}

	public InvocationByDeviceCriteriaRequest build() {
	    return this.build;
	}
    }
}