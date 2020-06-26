/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.scheduling.request;

import java.util.Map;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.scheduling.ScheduledJobState;
import com.sitewhere.spi.scheduling.ScheduledJobType;

/**
 * Includes values needed to create a scheduled job.
 */
public interface IScheduledJobCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get unique schedule token.
     * 
     * @return
     */
    String getScheduleToken();

    /**
     * Get job type.
     * 
     * @return
     */
    ScheduledJobType getJobType();

    /**
     * Get job configuration values.
     * 
     * @return
     */
    Map<String, String> getJobConfiguration();

    /**
     * Get job scheduling state.
     * 
     * @return
     */
    ScheduledJobState getJobState();
}