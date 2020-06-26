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
 * Parameters for a batch operation that executes a command for all devices in
 * the batch.
 */
public interface IBatchCommandInvocationRequest extends IPersistentEntityCreateRequest {

    /** Batch operation parameter name for command token */
    public static final String PARAM_COMMAND_TOKEN = "commandToken";

    /** Metadata property on batch element that holds invocation event id */
    public static final String META_INVOCATION_EVENT_ID = "invocation";

    /**
     * Device type for command.
     * 
     * @return
     */
    String getDeviceTypeToken();

    /**
     * Get token for command to be executed.
     * 
     * @return
     */
    String getCommandToken();

    /**
     * Get the list of parameter names mapped to values.
     * 
     * @return
     */
    Map<String, String> getParameterValues();

    /**
     * Get the list of targeted device tokens.
     * 
     * @return
     */
    List<String> getDeviceTokens();
}