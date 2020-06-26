/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch.request;

import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.batch.ElementProcessingStatus;

/**
 * Defines fields for creating/updating a batch element.
 */
public interface IBatchElementCreateRequest {

    /**
     * Get token for device affected by operation.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get processing status indicator.
     * 
     * @return
     */
    ElementProcessingStatus getProcessingStatus();

    /**
     * Get date element was processed.
     * 
     * @return
     */
    Date getProcessedDate();

    /**
     * Get metadata values.
     * 
     * @return
     */
    Map<String, String> getMetadata();
}