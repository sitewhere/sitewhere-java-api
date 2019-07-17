
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.scheduling;

import java.util.Collections;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.scheduling.ScheduledJob;
import com.sitewhere.rest.model.scheduling.request.ScheduledJobCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.scheduling.ScheduledJobResponseFormat;
import com.sitewhere.rest.model.search.scheduling.ScheduledJobSearchCriteria;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.scheduling.ScheduledJobState;
import com.sitewhere.spi.scheduling.ScheduledJobType;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class ScheduledJobRestTests extends AbstractCRUDRestClientTests<ScheduledJob, ScheduledJobCreateRequest>{

    @Override
    protected String knownEntityToken() {
	return "weekly";
    }
    
    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected ScheduledJobCreateRequest buildCreateRequest(String token) throws SiteWhereException {
	ScheduledJobCreateRequest request = new ScheduledJobCreateRequest();
	request.setJobState(ScheduledJobState.Active);
	request.setJobType(ScheduledJobType.BatchCommandInvocation);
	request.setScheduleToken(token);
	request.setToken(token);
	request.setJobConfiguration(Collections.emptyMap());
	return request;
    }

    @Override
    protected ScheduledJob createEntity(ScheduledJobCreateRequest createRequest) throws SiteWhereException {
	return getClient().createScheduledJob(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected ScheduledJob findEntityByToken(String token) throws SiteWhereException {
	return getClient().getScheduledJobByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected ScheduledJobCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	ScheduledJobCreateRequest request = new ScheduledJobCreateRequest();
	request.setJobState(ScheduledJobState.Active);
	request.setJobType(ScheduledJobType.BatchCommandInvocation);
	request.setScheduleToken(token);
	request.setToken(token);
	request.setJobConfiguration(Collections.emptyMap());
	return request;
    }

    @Override
    protected ScheduledJob updateEntity(String token, ScheduledJobCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateScheduledJob(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected ScheduledJob deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteScheduledJob(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------
    
    @Override
    protected SearchResults<ScheduledJob> listEntities() throws SiteWhereException {
	ScheduledJobSearchCriteria searchCriteria = new ScheduledJobSearchCriteria(0, 10);
	ScheduledJobResponseFormat responseFormat = new ScheduledJobResponseFormat();
	return getClient().listScheduledJobs(getTenatAuthentication(), searchCriteria, responseFormat);
    }
    
}
