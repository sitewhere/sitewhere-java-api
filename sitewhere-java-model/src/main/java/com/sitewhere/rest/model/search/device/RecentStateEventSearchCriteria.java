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
