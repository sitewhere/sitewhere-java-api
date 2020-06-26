/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch.request;

import java.util.List;
import java.util.Map;

import com.sitewhere.spi.batch.IBatchOperation;
import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Provides information needex to create an {@link IBatchOperation}.
 */
public interface IBatchOperationCreateRequest extends IPersistentEntityCreateRequest {

    /** Metadata property with token for batch operation that generated event */
    public static final String META_BATCH_OPERATION_TOKEN = "batch";

    /**
     * Get operation to be performed.
     * 
     * @return
     */
    String getOperationType();

    /**
     * Get operation parameters.
     * 
     * @return
     */
    Map<String, String> getParameters();

    /**
     * Get list of device tokens for operation.
     * 
     * @return
     */
    List<String> getDeviceTokens();
}