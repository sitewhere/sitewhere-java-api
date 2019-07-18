/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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