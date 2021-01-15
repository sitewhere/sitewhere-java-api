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
package com.sitewhere.spi.scheduling;

/**
 * Metadata constants for values used by various trigger types.
 */
public interface TriggerConstants {

    /**
     * Fields used by a simple trigger.
     */
    public static interface SimpleTrigger {

	/** Number of times trigger should repeat */
	public static final String REPEAT_COUNT = "repeatCount";

	/** Interval (in milliseconds) trigger should repeat */
	public static final String REPEAT_INTERVAL = "repeatInterval";
    }

    /**
     * Fields used by a cron trigger.
     */
    public static interface CronTrigger {

	/** Cron expression that defines trigger schedule */
	public static final String CRON_EXPRESSION = "cronExpression";
    }
}