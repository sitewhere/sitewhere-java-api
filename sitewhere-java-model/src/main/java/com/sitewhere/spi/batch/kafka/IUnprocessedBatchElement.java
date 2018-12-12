/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch.kafka;

import com.sitewhere.spi.batch.IBatchElement;

/**
 * Kafka payload for an unprocessed batch element.
 */
public interface IUnprocessedBatchElement {

    /**
     * Get batch element information.
     * 
     * @return
     */
    public IBatchElement getBatchElement();
}
