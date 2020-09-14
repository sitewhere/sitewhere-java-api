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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.scheduling.ISchedule;
import com.sitewhere.spi.scheduling.TriggerConstants;
import com.sitewhere.spi.scheduling.TriggerType;
import com.sitewhere.spi.scheduling.request.IScheduleCreateRequest;

/**
 * Holds fields needed to create a new schedule.
 */
@JsonInclude(Include.NON_NULL)
public class ScheduleCreateRequest extends PersistentEntityCreateRequest implements IScheduleCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 1453554726838184776L;

    /** Name */
    private String name;

    /** Trigger type */
    private TriggerType triggerType;

    /** Trigger configuration */
    private Map<String, String> triggerConfiguration;

    /** Date schedule takes effect */
    private Date startDate;

    /** Date schedule is no longer in effect */
    private Date endDate;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduleCreateRequest#getName()
     */
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduleCreateRequest#
     * getTriggerType()
     */
    public TriggerType getTriggerType() {
	return triggerType;
    }

    public void setTriggerType(TriggerType triggerType) {
	this.triggerType = triggerType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduleCreateRequest#
     * getTriggerConfiguration ()
     */
    public Map<String, String> getTriggerConfiguration() {
	return triggerConfiguration;
    }

    public void setTriggerConfiguration(Map<String, String> triggerConfiguration) {
	this.triggerConfiguration = triggerConfiguration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.scheduling.request.IScheduleCreateRequest#getStartDate( )
     */
    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.request.IScheduleCreateRequest#getEndDate()
     */
    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public static class Builder {

	/** Request being built */
	private ScheduleCreateRequest request = new ScheduleCreateRequest();

	public Builder(ISchedule schedule) {
	    request.setToken(schedule.getToken());
	    request.setName(schedule.getName());
	    request.setTriggerType(schedule.getTriggerType());
	    request.setTriggerConfiguration(schedule.getTriggerConfiguration());
	    request.setStartDate(schedule.getStartDate());
	    request.setEndDate(schedule.getEndDate());
	    request.setMetadata(schedule.getMetadata());
	}

	public Builder(String name) {
	    this(UUID.randomUUID().toString(), name);
	}

	public Builder(String token, String name) {
	    request.setToken(token);
	    request.setName(name);
	}

	public Builder withSimpleSchedule(Long interval, Integer count) {
	    request.setTriggerType(TriggerType.SimpleTrigger);
	    Map<String, String> config = new HashMap<String, String>();
	    if (interval != null) {
		config.put(TriggerConstants.SimpleTrigger.REPEAT_INTERVAL, String.valueOf(interval));
	    }
	    if (count != null) {
		config.put(TriggerConstants.SimpleTrigger.REPEAT_COUNT, String.valueOf(count));
	    }
	    request.setTriggerConfiguration(config);
	    return this;
	}

	public Builder withCronSchedule(String cronExpression) {
	    request.setTriggerType(TriggerType.CronTrigger);
	    Map<String, String> config = new HashMap<String, String>();
	    config.put(TriggerConstants.CronTrigger.CRON_EXPRESSION, cronExpression);
	    request.setTriggerConfiguration(config);
	    return this;
	}

	public Builder withStartDate(Date startDate) {
	    request.setStartDate(startDate);
	    return this;
	}

	public Builder withEndDate(Date endDate) {
	    request.setEndDate(endDate);
	    return this;
	}

	public ScheduleCreateRequest build() {
	    return request;
	}
    }
}