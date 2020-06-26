/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Holds information about a single element within an {@link IBatchOperation}.
 */
public interface IBatchElement extends IMetadataProvider, Serializable {

    /**
     * Get Unique id.
     * 
     * @return
     */
    UUID getId();

    /**
     * Get id for parent batch operation.
     * 
     * @return
     */
    UUID getBatchOperationId();

    /**
     * Get id for associated device.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get processing status indicator.
     * 
     * @return
     */
    ElementProcessingStatus getProcessingStatus();

    /**
     * Get the date on which the element was processed.
     * 
     * @return
     */
    Date getProcessedDate();
}