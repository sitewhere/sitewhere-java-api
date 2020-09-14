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
package com.sitewhere.rest.model.device.event.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.spi.device.command.IDeviceCommand;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;

/**
 * Merges information from an {@link IDeviceCommand} and an
 * {@link IDeviceCommandInvocation} in a form that is easy to use in a user
 * interface.
 */
public class DeviceCommandInvocationSummary extends MetadataProvider implements Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -1400511380311663352L;

    /** Command name */
    private String name;

    /** Command namespace */
    private String namespace;

    /** Formatted invocation date */
    private Date invocationDate;

    private List<Parameter> parameters = new ArrayList<Parameter>();

    /** List of responses for the command invocation */
    private List<Response> responses = new ArrayList<Response>();

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getNamespace() {
	return namespace;
    }

    public void setNamespace(String namespace) {
	this.namespace = namespace;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getInvocationDate() {
	return invocationDate;
    }

    public void setInvocationDate(Date invocationDate) {
	this.invocationDate = invocationDate;
    }

    public List<Parameter> getParameters() {
	return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
	this.parameters = parameters;
    }

    public List<Response> getResponses() {
	return responses;
    }

    public void setResponses(List<Response> responses) {
	this.responses = responses;
    }

    /** Holder for parameter information */
    public static class Parameter {

	/** Parameter name */
	private String name;

	/** Parameter type */
	private String type;

	/** Parameter value */
	private String value;

	/** Required indicator */
	private boolean required;

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}

	public String getValue() {
	    return value;
	}

	public void setValue(String value) {
	    this.value = value;
	}

	public boolean isRequired() {
	    return required;
	}

	public void setRequired(boolean required) {
	    this.required = required;
	}
    }

    /** Information about a response to the invocation */
    public static class Response {

	/** Parameter name */
	private String description;

	/** Parameter type */
	private Date date;

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING)
	public Date getDate() {
	    return date;
	}

	public void setDate(Date date) {
	    this.date = date;
	}
    }
}