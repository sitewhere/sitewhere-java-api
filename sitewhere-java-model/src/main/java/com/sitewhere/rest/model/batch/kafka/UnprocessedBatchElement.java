/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.batch.kafka;

import com.sitewhere.spi.batch.IBatchElement;
import com.sitewhere.spi.batch.kafka.IUnprocessedBatchElement;

/**
 * Kafka message that contains an unprocessed batch element.
 */
public class UnprocessedBatchElement implements IUnprocessedBatchElement {

    /** Batch element */
    private IBatchElement batchElement;

    /*
     * @see com.sitewhere.spi.batch.kafka.IUnprocessedBatchElement#getBatchElement()
     */
    @Override
    public IBatchElement getBatchElement() {
	return batchElement;
    }

    public void setBatchElement(IBatchElement batchElement) {
	this.batchElement = batchElement;
    }
}
