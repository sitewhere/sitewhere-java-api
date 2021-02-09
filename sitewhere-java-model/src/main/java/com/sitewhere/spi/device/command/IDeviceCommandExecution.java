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
package com.sitewhere.spi.device.command;

import java.io.Serializable;
import java.util.Map;

import com.sitewhere.spi.device.event.IDeviceCommandInvocation;

/**
 * Represents an {@link IDeviceCommand} combined with an
 * {@link IDeviceCommandInvocation} to represent the actual call made to the
 * target.
 */
public interface IDeviceCommandExecution extends Serializable {

    /**
     * Get the command being executed.
     * 
     * @return
     */
    IDeviceCommand getCommand();

    /**
     * Get the invocation details.
     * 
     * @return
     */
    IDeviceCommandInvocation getInvocation();

    /**
     * Get parameters populated with data from the invocation.
     * 
     * @return
     */
    Map<String, Object> getParameters();
}