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
public class ScheduledJobRestTests extends AbstractCRUDRestClientTests<ScheduledJob, ScheduledJobCreateRequest> {

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
    protected ScheduledJob updateEntity(String token, ScheduledJobCreateRequest updateRequest)
	    throws SiteWhereException {
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
