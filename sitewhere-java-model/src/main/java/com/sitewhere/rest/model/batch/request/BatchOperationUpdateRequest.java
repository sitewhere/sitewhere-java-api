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
package com.sitewhere.rest.model.batch.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.batch.BatchOperationStatus;
import com.sitewhere.spi.batch.request.IBatchOperationUpdateRequest;

/**
 * Holds information needed to update a batch operation.
 */
@JsonInclude(Include.NON_NULL)
public class BatchOperationUpdateRequest extends PersistentEntityCreateRequest implements IBatchOperationUpdateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 7636526750514669256L;

    /** Processing status for operation */
    private BatchOperationStatus processingStatus;

    /** Date when operation processing started */
    private Date processingStartedDate;

    /** Date when operation processing ended */
    private Date processingEndedDate;

    /*
     * @see com.sitewhere.spi.batch.request.IBatchOperationUpdateRequest#
     * getProcessingStatus()
     */
    @Override
    public BatchOperationStatus getProcessingStatus() {
	return processingStatus;
    }

    public void setProcessingStatus(BatchOperationStatus processingStatus) {
	this.processingStatus = processingStatus;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchOperationUpdateRequest#
     * getProcessingStartedDate()
     */
    @Override
    public Date getProcessingStartedDate() {
	return processingStartedDate;
    }

    public void setProcessingStartedDate(Date processingStartedDate) {
	this.processingStartedDate = processingStartedDate;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchOperationUpdateRequest#
     * getProcessingEndedDate()
     */
    @Override
    public Date getProcessingEndedDate() {
	return processingEndedDate;
    }

    public void setProcessingEndedDate(Date processingEndedDate) {
	this.processingEndedDate = processingEndedDate;
    }
}