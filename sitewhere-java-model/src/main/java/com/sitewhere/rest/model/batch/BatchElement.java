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
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.spi.batch.ElementProcessingStatus;
import com.sitewhere.spi.batch.IBatchElement;

/**
 * Model object for a batch element.
 */
@JsonInclude(Include.NON_NULL)
public class BatchElement extends MetadataProvider implements IBatchElement {

    /** Serialization version identifier */
    private static final long serialVersionUID = 7080873473253195755L;

    /** Unqiue id */
    private UUID id;

    /** Id for parent batch operation */
    private UUID batchOperationId;

    /** Id for device */
    private UUID deviceId;

    /** Processing status */
    private ElementProcessingStatus processingStatus;

    /** Date on which element was processed */
    private Date processedDate;

    /*
     * @see com.sitewhere.spi.batch.IBatchElement#getId()
     */
    @Override
    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    /*
     * @see com.sitewhere.spi.batch.IBatchElement#getBatchOperationId()
     */
    @Override
    public UUID getBatchOperationId() {
	return batchOperationId;
    }

    public void setBatchOperationId(UUID batchOperationId) {
	this.batchOperationId = batchOperationId;
    }

    /*
     * @see com.sitewhere.spi.batch.IBatchElement#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.batch.IBatchElement#getProcessingStatus()
     */
    @Override
    public ElementProcessingStatus getProcessingStatus() {
	return processingStatus;
    }

    public void setProcessingStatus(ElementProcessingStatus processingStatus) {
	this.processingStatus = processingStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.batch.IBatchElement#getProcessedDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getProcessedDate() {
	return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
	this.processedDate = processedDate;
    }
}