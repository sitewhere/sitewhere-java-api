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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.scheduling.ISchedule;
import com.sitewhere.spi.scheduling.TriggerType;

/**
 * Model object for a schedule.
 */
@JsonInclude(Include.NON_NULL)
public class Schedule extends PersistentEntity implements ISchedule {

    /** Serial version UID */
    private static final long serialVersionUID = -1316208751255296000L;

    /** Schedule name */
    private String name;

    /** Type of trigger */
    private TriggerType triggerType;

    /** Configuration of trigger */
    private Map<String, String> triggerConfiguration = new HashMap<String, String>();

    /** Date schedule takes effect */
    private Date startDate;

    /** Date schedule is no longer in effect */
    private Date endDate;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.ISchedule#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.ISchedule#getTriggerType()
     */
    @Override
    public TriggerType getTriggerType() {
	return triggerType;
    }

    public void setTriggerType(TriggerType triggerType) {
	this.triggerType = triggerType;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.ISchedule#getTriggerConfiguration()
     */
    @Override
    public Map<String, String> getTriggerConfiguration() {
	return triggerConfiguration;
    }

    public void setTriggerConfiguration(Map<String, String> triggerConfiguration) {
	this.triggerConfiguration = triggerConfiguration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.ISchedule#getStartDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.scheduling.ISchedule#getEndDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }
}