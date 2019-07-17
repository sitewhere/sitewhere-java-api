
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.scheduling;

import java.util.Date;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.scheduling.Schedule;
import com.sitewhere.rest.model.scheduling.request.ScheduleCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.scheduling.ScheduleResponseFormat;
import com.sitewhere.rest.model.search.scheduling.ScheduleSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class ScheduleRestTests extends AbstractCRUDRestClientTests<Schedule, ScheduleCreateRequest>{

    @Override
    protected String knownEntityToken() {
	return "weekly";
    }
    
    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected ScheduleCreateRequest buildCreateRequest(String token) throws SiteWhereException {
	String name = "test schedule";
	ScheduleCreateRequest.Builder builder = new ScheduleCreateRequest.Builder(token, name);
	
	builder.withStartDate(new Date());
	builder.withSimpleSchedule(10000l, 1);
	
	return builder.build();
    }

    @Override
    protected Schedule createEntity(ScheduleCreateRequest createRequest) throws SiteWhereException {
	return getClient().createSchedule(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Schedule findEntityByToken(String token) throws SiteWhereException {
	return getClient().getScheduleByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected ScheduleCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String name = "test schedule";
	ScheduleCreateRequest.Builder builder = new ScheduleCreateRequest.Builder(token, name);
	
	builder.withStartDate(new Date());
	builder.withSimpleSchedule(10000l, 2);
	
	return builder.build();
    }

    @Override
    protected Schedule updateEntity(String token, ScheduleCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateSchedule(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Schedule deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteSchedule(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------
    
    @Override
    protected SearchResults<Schedule> listEntities() throws SiteWhereException {
	ScheduleSearchCriteria searchCriteria = new ScheduleSearchCriteria(0, 10);
	ScheduleResponseFormat responseFormat = new ScheduleResponseFormat();
	return getClient().listSchedules(getTenatAuthentication(), searchCriteria, responseFormat);
    }
    
}
