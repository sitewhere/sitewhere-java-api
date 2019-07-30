/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
