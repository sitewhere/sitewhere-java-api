/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.batch.request;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.batch.ElementProcessingStatus;
import com.sitewhere.spi.batch.request.IBatchElementCreateRequest;

/**
 * Holds information needed to create/update a batch operation element.
 */
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