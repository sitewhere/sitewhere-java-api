/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch;

import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Interface for an operation that is applied to multiple devices.
 */
public interface IBatchOperation extends IPersistentEntity {

    /**
     * Gets the type of operation to be performed.
     * 
     * @return
     */
    String getOperationType();

    /**
     * Operation parameters.
     * 
     * @return
     */
    Map<String, String> getParameters();

    /**
     * Get processing status for the batch operation.
     * 
     * @return
     */
    BatchOperationStatus getProcessingStatus();

    /**
     * Get the date when processing of the operation started.
     * 
     * @return
     */
    Date getProcessingStartedDate();

    /**
     * Get the date when processing of the operation ended.
     * 
     * @return
     */
    Date getProcessingEndedDate();
}