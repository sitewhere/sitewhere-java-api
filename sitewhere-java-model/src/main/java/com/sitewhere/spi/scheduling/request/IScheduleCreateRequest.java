/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.scheduling.request;

import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.scheduling.TriggerType;

/**
 * Supplies information needed to create or update a schedule.
 */
public interface IScheduleCreateRequest extends IPersistentEntityCreateRequest {

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