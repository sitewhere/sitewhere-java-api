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

/**
 * Request from a device to update its state in SiteWhere.
 */
public interface IDeviceStateChangeCreateRequest extends IDeviceEventCreateRequest {

    /** State change category for registration */
    public static final String ATTRIBUTE_REGISTRATION = "registration";

    /** State change category for device assignment */
    public static final String ATTRIBUTE_ASSIGNMENT = "assignment";

    /** State change category for presence management */
    public static final String ATTRIBUTE_PRESENCE = "presence";

    /**
     * Get attribute being changed.
     * 
     * @return
     */
    String getAttribute();

    /**
     * Get type of state change.
     * 
     * @return
     */
    String getType();

    /**
     * Get the previous (or assumed previous) state.
     * 
     * @return
     */
    String getPreviousState();

    /**
     * Get the requested new state.
     * 
     * @return
     */
    String getNewState();
}