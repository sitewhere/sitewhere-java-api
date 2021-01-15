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
package com.sitewhere.rest.model.batch.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.request.IInvocationByAssignmentCriteriaRequest;

/**
 * Request for creating command invocations for devices whose assignments match
 * the given criteria.
 */
@JsonInclude(Include.NON_NULL)
public class InvocationByAssignmentCriteriaRequest extends PersistentEntityCreateRequest
	implements IInvocationByAssignmentCriteriaRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 762778805204360322L;

    /** Device type token */
    private String deviceTypeToken;

    /** Device command token */
    private String commandToken;

    /** Map of parameter values */
    private Map<String, String> parameterValues = new HashMap<String, String>();

    /** Customer tokens */
    private List<String> customerTokens;

    /** Area tokens */
    private List<String> areaTokens;

    /** Asset tokens */
    private List<String> assetTokens;

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getCommandToken()
     */
    @Override
    public String getCommandToken() {
	return commandToken;
    }

    public void setCommandToken(String commandToken) {
	this.commandToken = commandToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getParameterValues()
     */
    @Override
    public Map<String, String> getParameterValues() {
	return parameterValues;
    }

    public void setParameterValues(Map<String, String> parameterValues) {
	this.parameterValues = parameterValues;
    }

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getCustomerTokens()
     */
    @Override
    public List<String> getCustomerTokens() {
	return customerTokens;
    }

    public void setCustomerTokens(List<String> customerTokens) {
	this.customerTokens = customerTokens;
    }

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getAreaTokens()
     */
    @Override
    public List<String> getAreaTokens() {
	return areaTokens;
    }

    public void setAreaTokens(List<String> areaTokens) {
	this.areaTokens = areaTokens;
    }

    /*
     * @see com.sitewhere.spi.batch.request.invocation.
     * IInvocationByAssignmentCriteriaRequest#getAssetTokens()
     */
    @Override
    public List<String> getAssetTokens() {
	return assetTokens;
    }

    public void setAssetTokens(List<String> assetTokens) {
	this.assetTokens = assetTokens;
    }

    public static class Builder {

	/** Build object */
	private InvocationByAssignmentCriteriaRequest build;

	private Builder() {
	    super();
	    this.build = new InvocationByAssignmentCriteriaRequest();
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

	public Builder withCustomerTokens(List<String> tokens) {
	    if (this.build.getCustomerTokens() == null) {
		this.build.setCustomerTokens(new ArrayList<String>());
	    }
	    this.build.getCustomerTokens().addAll(tokens);
	    return this;
	}

	public Builder withAreaTokens(List<String> tokens) {
	    if (this.build.getAreaTokens() == null) {
		this.build.setAreaTokens(new ArrayList<String>());
	    }
	    this.build.getAreaTokens().addAll(tokens);
	    return this;
	}

	public Builder withAssetTokens(List<String> tokens) {
	    if (this.build.getAssetTokens() == null) {
		this.build.setAssetTokens(new ArrayList<String>());
	    }
	    this.build.getAssetTokens().addAll(tokens);
	    return this;
	}

	public InvocationByAssignmentCriteriaRequest build() {
	    return this.build;
	}
    }
}
