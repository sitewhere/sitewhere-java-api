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
package com.sitewhere.rest.model.scheduling.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.scheduling.ScheduledJobState;
import com.sitewhere.spi.scheduling.ScheduledJobType;
import com.sitewhere.spi.scheduling.request.IScheduledJobCreateRequest;

/**
 * Holds fields needed to create a new scheduled job.
 */
@JsonInclude(Include.NON_NULL)
public class ScheduledJobCreateRequest extends PersistentEntityCreateRequest implements IScheduledJobCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -627595397893118687L;

    /** Token for associated schedule */
    private String scheduleToken;

    /** Job type */
    private ScheduledJobType jobType;

    /** Job configuration */
    private Map<String, String> jobConfiguration;

    /** Job state */
    private ScheduledJobState jobState;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduledJobCreateRequest#
     * getScheduleToken()
     */
    public String getScheduleToken() {
	return scheduleToken;
    }

    public void setScheduleToken(String scheduleToken) {
	this.scheduleToken = scheduleToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduledJobCreateRequest#
     * getJobType()
     */
    public ScheduledJobType getJobType() {
	return jobType;
    }

    public void setJobType(ScheduledJobType jobType) {
	this.jobType = jobType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduledJobCreateRequest#
     * getJobConfiguration ()
     */
    public Map<String, String> getJobConfiguration() {
	return jobConfiguration;
    }

    public void setJobConfiguration(Map<String, String> jobConfiguration) {
	this.jobConfiguration = jobConfiguration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduledJobCreateRequest#
     * getJobState()
     */
    public ScheduledJobState getJobState() {
	return jobState;
    }

    public void setJobState(ScheduledJobState jobState) {
	this.jobState = jobState;
    }
}