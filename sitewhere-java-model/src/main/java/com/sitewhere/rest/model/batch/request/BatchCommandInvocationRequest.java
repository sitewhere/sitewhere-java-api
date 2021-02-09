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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest;

/**
 * Request for invoking a device command for multiple devices.
 */
@JsonInclude(Include.NON_NULL)
public class BatchCommandInvocationRequest extends PersistentEntityCreateRequest
	implements IBatchCommandInvocationRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = -8215264923380389864L;

    /** Device type token for command */
    private String deviceTypeToken;

    /** Token for command to be executed */
    private String commandToken;

    /** Values for command parameters */
    private Map<String, String> parameterValues = new HashMap<String, String>();

    /** List of targeted device tokens */
    private List<String> deviceTokens;

    /*
     * @see
     * com.sitewhere.spi.batch.request.invocation.IBatchCommandInvocationRequest#
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
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getCommandToken()
     */
    @Override
    public String getCommandToken() {
	return commandToken;
    }

    public void setCommandToken(String commandToken) {
	this.commandToken = commandToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getParameterValues()
     */
    @Override
    public Map<String, String> getParameterValues() {
	return parameterValues;
    }

    public void setParameterValues(Map<String, String> parameterValues) {
	this.parameterValues = parameterValues;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchCommandInvocationRequest#
     * getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }

    /**
     * Get new builder class.
     * 
     * @return
     */
    public static Builder newBuilder() {
	return new Builder();
    }

    public static class Builder {

	/** Build object */
	private BatchCommandInvocationRequest build;

	private Builder() {
	    super();
	    this.build = new BatchCommandInvocationRequest();
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

	public Builder withDeviceTokens(List<String> deviceTokens) {
	    if (this.build.getDeviceTokens() == null) {
		this.build.setDeviceTokens(new ArrayList<String>());
	    }
	    this.build.getDeviceTokens().addAll(deviceTokens);
	    return this;
	}

	public Builder withDeviceToken(String deviceToken) {
	    withDeviceTokens(Collections.singletonList(deviceToken));
	    return this;
	}

	public Builder withParameter(String name, String value) {
	    this.build.getParameterValues().put(name, value);
	    return this;
	}

	public BatchCommandInvocationRequest build() {
	    return this.build;
	}
    }
}