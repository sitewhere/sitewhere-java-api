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
package com.sitewhere.rest.model.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.batch.BatchOperationStatus;
import com.sitewhere.spi.batch.IBatchOperation;

/**
 * Model object for a batch operation.
 */
@JsonInclude(Include.NON_NULL)
public class BatchOperation extends PersistentEntity implements IBatchOperation {

    /** Serialization version identifier */
    private static final long serialVersionUID = -228183022121018340L;

    /** Operation type requested */
    private String operationType;

    /** Operation parameters */
    private Map<String, String> parameters = new HashMap<String, String>();

    /** Processing status for operation */
    private BatchOperationStatus processingStatus = BatchOperationStatus.Unprocessed;

    /** Date when operation processing started */
    private Date processingStartedDate;

    /** Date when operation processing ended */
    private Date processingEndedDate;

    /*
     * @see com.sitewhere.spi.batch.IBatchOperation#getOperationType()
     */
    @Override
    public String getOperationType() {
	return operationType;
    }

    public void setOperationType(String operationType) {
	this.operationType = operationType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.batch.IBatchOperation#getParameters()
     */
    @Override
    public Map<String, String> getParameters() {
	return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
	this.parameters = parameters;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.batch.IBatchOperation#getProcessingStatus()
     */
    @Override
    public BatchOperationStatus getProcessingStatus() {
	return processingStatus;
    }

    public void setProcessingStatus(BatchOperationStatus processingStatus) {
	this.processingStatus = processingStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.batch.IBatchOperation#getProcessingStartedDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getProcessingStartedDate() {
	return processingStartedDate;
    }

    public void setProcessingStartedDate(Date processingStartedDate) {
	this.processingStartedDate = processingStartedDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.batch.IBatchOperation#getProcessingEndedDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getProcessingEndedDate() {
	return processingEndedDate;
    }

    public void setProcessingEndedDate(Date processingEndedDate) {
	this.processingEndedDate = processingEndedDate;
    }
}