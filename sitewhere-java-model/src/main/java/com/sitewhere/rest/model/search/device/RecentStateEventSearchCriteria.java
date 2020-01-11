/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.device;

import java.util.UUID;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.search.device.IRecentStateEventSearchCriteria;

/**
 * Provides filter criteria for recent state event searches.
 */
public class RecentStateEventSearchCriteria extends SearchCriteria implements IRecentStateEventSearchCriteria {

    /** Device state id */
    private UUID deviceStateId;

    /** Event type */
    private DeviceEventType eventType;

    /** Classifier */
    private String classifier;

    public RecentStateEventSearchCriteria() {
	super();
    }

    public RecentStateEventSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.device.IRecentStateEventSearchCriteria#
     * getDeviceStateId()
     */
    @Override
    public UUID getDeviceStateId() {
	return deviceStateId;
    }

    public void setDeviceStateId(UUID deviceStateId) {
	this.deviceStateId = deviceStateId;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IRecentStateEventSearchCriteria#getEventType(
     * )
     */
    @Override
    public DeviceEventType getEventType() {
	return eventType;
    }

    public void setEventType(DeviceEventType eventType) {
	this.eventType = eventType;
    }

    /*
     * @see
     * com.sitewhere.spi.search.device.IRecentStateEventSearchCriteria#getClassifier
     * ()
     */
    @Override
    public String getClassifier() {
	return classifier;
    }

    public void setClassifier(String classifier) {
	this.classifier = classifier;
    }
}
