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
public class ScheduleRestTests extends AbstractCRUDRestClientTests<Schedule, ScheduleCreateRequest> {

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
