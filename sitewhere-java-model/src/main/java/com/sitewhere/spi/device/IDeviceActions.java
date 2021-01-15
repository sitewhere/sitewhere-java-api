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
package com.sitewhere.spi.device;

import java.math.BigDecimal;
import java.util.Map;

import com.sitewhere.spi.SiteWhereException;

/**
 * Provides simple methods for invoking commonly used SiteWhere actions.
 */
public interface IDeviceActions {

    /**
     * Create a new location for the given assignment.
     * 
     * @param assignment
     * @param latitude
     * @param longitude
     * @param elevation
     * @param updateState
     * @throws SiteWhereException
     */
    public void createLocation(IDeviceAssignment assignment, BigDecimal latitude, BigDecimal longitude,
	    BigDecimal elevation, boolean updateState) throws SiteWhereException;

    /**
     * Send command to a device.
     * 
     * @param assignment
     * @param command
     * @param parameters
     * @throws SiteWhereException
     */
    public void sendCommand(IDeviceAssignment assignment, String command, Map<String, String> parameters)
	    throws SiteWhereException;
}