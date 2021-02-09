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