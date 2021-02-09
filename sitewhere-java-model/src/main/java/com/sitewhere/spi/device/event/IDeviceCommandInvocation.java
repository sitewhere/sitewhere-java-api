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
package com.sitewhere.spi.device.event;

import java.util.Map;
import java.util.UUID;

/**
 * Captures information about the invocation of a command.
 */
public interface IDeviceCommandInvocation extends IDeviceEvent {

    /**
     * Get actor type that initiated the command.
     * 
     * @return
     */
    CommandInitiator getInitiator();

    /**
     * Get unique id of command initiated.
     * 
     * @return
     */
    String getInitiatorId();

    /**
     * Get actor type that received command.
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
     * Get unique id of device command being invoked.
     * 
     * @return
     */
    UUID getDeviceCommandId();

    /**
     * Get the list of parameter names mapped to values.
     * 
     * @return
     */
    Map<String, String> getParameterValues();
}