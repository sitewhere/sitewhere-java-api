/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch.request;

import java.util.List;
import java.util.Map;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Provides values needed for sending a {@link IBatchCommandInvocationRequest}
 * based on device assignments that meet given criteria.
 */
public interface IInvocationByAssignmentCriteriaRequest extends IPersistentEntityCreateRequest {

    /**
     * If set, only devices with the given device type token will be sent the
     * command.
     * 
     * @return
     */
    public String getDeviceTypeToken();

    /**
     * Get token for command to be executed.
     * 
     * @return
     */
    public String getCommandToken();

    /**
     * Get the list of parameter names mapped to values.
     * 
     * @return
     */
    public Map<String, String> getParameterValues();

    /**
     * If set, only assignments associated with the given customers will be sent the
     * command.
     * 
     * @return
     */
    public List<String> getCustomerTokens();

    /**
     * If set, only assignments associated with the given areas will be sent the
     * command.
     * 
     * @return
     */
    public List<String> getAreaTokens();

    /**
     * If set, only assignments associated with the given assets will be sent the
     * command.
     * 
     * @return
     */
    public List<String> getAssetTokens();
}
