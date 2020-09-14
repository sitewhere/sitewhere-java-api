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
package com.sitewhere.spi.search.device;

/**
 * Determines which content is returned for device state responses.
 */
public interface IDeviceStateResponseFormat {

    /**
     * Indicates if area is included.
     * 
     * @return
     */
    Boolean getIncludeArea();

    /**
     * Indicates if asset is included.
     * 
     * @return
     */
    Boolean getIncludeAsset();

    /**
     * Indicates if customer is included.
     * 
     * @return
     */
    Boolean getIncludeCustomer();

    /**
     * Indicates if device is included.
     * 
     * @return
     */
    Boolean getIncludeDevice();

    /**
     * Indicates if device assignment is included.
     * 
     * @return
     */
    Boolean getIncludeDeviceAssignment();

    /**
     * Indicates if device type is included.
     * 
     * @return
     */
    Boolean getIncludeDeviceType();

    /**
     * Indicates if event details is included.
     * 
     * @return
     */
    Boolean getIncludeEventDetails();
}
