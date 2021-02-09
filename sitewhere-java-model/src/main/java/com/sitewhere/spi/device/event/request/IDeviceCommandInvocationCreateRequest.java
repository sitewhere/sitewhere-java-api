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
package com.sitewhere.spi.device.event.request;

import java.util.Map;

import com.sitewhere.spi.device.event.CommandInitiator;
import com.sitewhere.spi.device.event.CommandTarget;

/**
 * Interface for arguments needed to create a device command invocation.
 */
public interface IDeviceCommandInvocationCreateRequest extends IDeviceEventCreateRequest {

    /**
     * Get command initiator type.
     * 
     * @return
     */
    CommandInitiator getInitiator();

    /**
     * Get unique id of command inititator.
     * 
     * @return
     */
    String getInitiatorId();

    /**
     * Get command target type.
     * 
     * @return
     */
    CommandTarget getTarget();

    /**
     * Get unique id of command target.
     * 
     * @return
     */
    String getTargetId();

    /**
     * Get unique token for command to invoke.
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