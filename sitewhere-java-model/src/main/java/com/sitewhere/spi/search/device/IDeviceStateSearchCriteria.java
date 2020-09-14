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

import java.util.Date;
import java.util.List;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Provides filter criteria for device state searches.
 */
public interface IDeviceStateSearchCriteria extends ISearchCriteria {

    /**
     * If set, will limit results to those with a last interaction date before this
     * value.
     * 
     * @return
     */
    Date getLastInteractionDateBefore();

    /**
     * List of devices to be included in results.
     * 
     * @return
     */
    List<String> getDeviceTokens();

    /**
     * List of device assignments to be included in results.
     * 
     * @return
     */
    List<String> getDeviceAssignmentTokens();

    /**
     * List of device types to be included in results.
     * 
     * @return
     */
    List<String> getDeviceTypeTokens();

    /**
     * List of customers to be included in results.
     * 
     * @return
     */
    List<String> getCustomerTokens();

    /**
     * List of areas to be included in results.
     * 
     * @return
     */
    List<String> getAreaTokens();

    /**
     * List of assets to be included in results.
     * 
     * @return
     */
    List<String> getAssetTokens();
}