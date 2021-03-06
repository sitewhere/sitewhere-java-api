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
package com.sitewhere.spi.scheduling;

import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Represents a named schedule that can be applied to system actions.
 */
public interface ISchedule extends IPersistentEntity {

    /**
     * Schedule name.
     * 
     * @return
     */
    String getName();

    /**
     * Get type of trigger for schedule.
     * 
     * @return
     */
    TriggerType getTriggerType();

    /**
     * Get trigger configuration values.
     * 
     * @return
     */
    Map<String, String> getTriggerConfiguration();

    /**
     * Get date schedule takes effect.
     * 
     * @return
     */
    Date getStartDate();

    /**
     * Get date schedule is no longer in effect.
     * 
     * @return
     */
    Date getEndDate();
}