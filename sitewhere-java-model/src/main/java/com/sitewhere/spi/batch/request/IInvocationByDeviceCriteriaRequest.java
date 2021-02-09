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

import java.util.Map;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Provides values needed for sending a {@link IBatchCommandInvocationRequest}
 * based on devices that meet given criteria.
 */
public interface IInvocationByDeviceCriteriaRequest extends IPersistentEntityCreateRequest {

    /**
     * If set, only devices with the given device type token will be sent the
     * command.
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
}