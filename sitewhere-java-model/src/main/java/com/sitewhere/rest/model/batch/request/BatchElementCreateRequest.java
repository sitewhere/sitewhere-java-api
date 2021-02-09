/**
 * Copyright © 2014-2021 The SiteWhere Authors
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

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.batch.ElementProcessingStatus;
import com.sitewhere.spi.batch.request.IBatchElementCreateRequest;

/**
 * Holds information needed to create/update a batch operation element.
 */
@JsonInclude(Include.NON_NULL)
public class BatchElementCreateRequest implements IBatchElementCreateRequest, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -3369336266183401785L;

    /** Token for affected device */
    private String deviceToken;

    /** Processing status for update */
    private ElementProcessingStatus processingStatus;

    /** Date element was processed */
    private Date processedDate;

    /** Metadata values */
    private Map<String, String> metadata;

    /*
     * @see
     * com.sitewhere.spi.batch.request.IBatchElementCreateRequest#getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchElementCreateRequest#
     * getProcessingStatus()
     */
    @Override
    public ElementProcessingStatus getProcessingStatus() {
	return processingStatus;
    }

    public void setProcessingStatus(ElementProcessingStatus processingStatus) {
	this.processingStatus = processingStatus;
    }

    /*
     * @see
     * com.sitewhere.spi.batch.request.IBatchElementCreateRequest#getProcessedDate()
     */
    @Override
    public Date getProcessedDate() {
	return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
	this.processedDate = processedDate;
    }

    /*
     * @see com.sitewhere.spi.batch.request.IBatchElementCreateRequest#getMetadata()
     */
    @Override
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }
}