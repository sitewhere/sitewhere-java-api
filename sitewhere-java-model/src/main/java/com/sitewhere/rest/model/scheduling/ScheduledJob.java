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
package com.sitewhere.rest.model.scheduling;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.scheduling.IScheduledJob;
import com.sitewhere.spi.scheduling.ScheduledJobState;
import com.sitewhere.spi.scheduling.ScheduledJobType;

/**
 * Model object for a scheduled job.
 */
@JsonInclude(Include.NON_NULL)
public class ScheduledJob extends PersistentEntity implements IScheduledJob {

    /** Serial version UID */
    private static final long serialVersionUID = -8440919585518011992L;

    /** Id for associated schedule */
    private UUID scheduleId;

    /** Job type */
    private ScheduledJobType jobType;

    /** Job configuration */
    private Map<String, String> jobConfiguration = new HashMap<String, String>();

    /** Job state */
    private ScheduledJobState jobState;

    /** FIELDS BELOW DEPEND ON MARSHALING PARAMETERS */

    /** Extra context information based on job type */
    private Map<String, Object> context;

    /*
     * @see com.sitewhere.spi.scheduling.IScheduledJob#getScheduleId()
     */
    @Override
    public UUID getScheduleId() {
	return scheduleId;
    }

    public void setScheduleId(UUID scheduleId) {
	this.scheduleId = scheduleId;
    }

    /*
     * @see com.sitewhere.spi.scheduling.IScheduledJob#getJobType()
     */
    @Override
    public ScheduledJobType getJobType() {
	return jobType;
    }

    public void setJobType(ScheduledJobType jobType) {
	this.jobType = jobType;
    }

    /*
     * @see com.sitewhere.spi.scheduling.IScheduledJob#getJobConfiguration()
     */
    @Override
    public Map<String, String> getJobConfiguration() {
	return jobConfiguration;
    }

    public void setJobConfiguration(Map<String, String> jobConfiguration) {
	this.jobConfiguration = jobConfiguration;
    }

    /*
     * @see com.sitewhere.spi.scheduling.IScheduledJob#getJobState()
     */
    @Override
    public ScheduledJobState getJobState() {
	return jobState;
    }

    public void setJobState(ScheduledJobState jobState) {
	this.jobState = jobState;
    }

    public Map<String, Object> getContext() {
	return context;
    }

    public void setContext(Map<String, Object> context) {
	this.context = context;
    }
}