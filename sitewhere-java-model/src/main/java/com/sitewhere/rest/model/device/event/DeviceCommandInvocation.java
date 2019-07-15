/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.event.CommandInitiator;
import com.sitewhere.spi.device.event.CommandTarget;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceCommandInvocation;

/**
 * Implementation of {@link IDeviceCommandInvocation}.
 * 
 * @author Derek
 */
@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class DeviceCommandInvocation extends DeviceEvent implements IDeviceCommandInvocation, Serializable {

    /** For Java serialization */
    private static final long serialVersionUID = -7389600825785131041L;

    /** Type of actor that initiated the command */
    private CommandInitiator initiator;

    /** Id of actor that initiated the command */
    private String initiatorId;

    /** Type of actor that will receive the command */
    private CommandTarget target;

    /** Id of actor that will receive the command */
    private String targetId;

    /** Unique id of command to execute */
    private UUID deviceCommandId;

    /** Values to use for command parameters */
    private Map<String, String> parameterValues = new HashMap<String, String>();

    public DeviceCommandInvocation() {
	super(DeviceEventType.CommandInvocation);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceCommandInvocation#getInitiator()
     */
    @Override
    public CommandInitiator getInitiator() {
	return initiator;
    }

    public void setInitiator(CommandInitiator initiator) {
	this.initiator = initiator;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceCommandInvocation#getInitiatorId()
     */
    @Override
    public String getInitiatorId() {
	return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
	this.initiatorId = initiatorId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceCommandInvocation#getTarget()
     */
    @Override
    public CommandTarget getTarget() {
	return target;
    }

    public void setTarget(CommandTarget target) {
	this.target = target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceCommandInvocation#getTargetId()
     */
    @Override
    public String getTargetId() {
	return targetId;
    }

    public void setTargetId(String targetId) {
	this.targetId = targetId;
    }

    /*
     * @see
     * com.sitewhere.spi.device.event.IDeviceCommandInvocation#getDeviceCommandId()
     */
    @Override
    public UUID getDeviceCommandId() {
	return deviceCommandId;
    }

    public void setDeviceCommandId(UUID deviceCommandId) {
	this.deviceCommandId = deviceCommandId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.IDeviceCommandInvocation#
     * getParameterValues()
     */
    @Override
    public Map<String, String> getParameterValues() {
	return parameterValues;
    }

    public void setParameterValues(Map<String, String> parameterValues) {
	this.parameterValues = parameterValues;
    }
}