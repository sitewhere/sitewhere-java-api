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
package com.sitewhere.rest.model.batch.kafka;

import java.util.List;

import com.sitewhere.spi.batch.IBatchOperation;
import com.sitewhere.spi.batch.kafka.IUnprocessedBatchOperation;

/**
 * Model object for a batch operation that has not been processed into batch
 * elements.
 */
public class UnprocessedBatchOperation implements IUnprocessedBatchOperation {

    /** Batch operation */
    private IBatchOperation batchOperation;

    /** List of device tokens for operation */
    private List<String> deviceTokens;

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IUnprocessedBatchOperation#
     * getBatchOperation()
     */
    @Override
    public IBatchOperation getBatchOperation() {
	return batchOperation;
    }

    public void setBatchOperation(IBatchOperation batchOperation) {
	this.batchOperation = batchOperation;
    }

    /*
     * @see com.sitewhere.spi.microservice.kafka.payload.IUnprocessedBatchOperation#
     * getDeviceTokens()
     */
    @Override
    public List<String> getDeviceTokens() {
	return deviceTokens;
    }

    public void setDeviceTokens(List<String> deviceTokens) {
	this.deviceTokens = deviceTokens;
    }
}
