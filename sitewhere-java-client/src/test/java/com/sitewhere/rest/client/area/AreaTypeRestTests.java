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
package com.sitewhere.rest.client.area;

import com.sitewhere.rest.client.AbstractWithLabelCRUDRestTest;
import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.rest.model.area.request.AreaTypeCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.area.AreaTypeSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class AreaTypeRestTests extends AbstractWithLabelCRUDRestTest<AreaType, AreaTypeCreateRequest> {

    private String areaTypeName = "Test Area Type Name";

    @Override
    protected String knownEntityToken() {
	return "construction";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected AreaTypeCreateRequest buildCreateRequest(String token) {
	AreaTypeCreateRequest.Builder builder = new AreaTypeCreateRequest.Builder(token, areaTypeName);

	builder.withDescription("Some description");

	return builder.build();
    }

    @Override
    protected AreaType createEntity(AreaTypeCreateRequest createRequest) throws SiteWhereException {
	return getClient().createAreaType(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected AreaType findEntityByToken(String token) throws SiteWhereException {
	return getClient().getAreaTypeByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected AreaTypeCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	AreaTypeCreateRequest.Builder builder = new AreaTypeCreateRequest.Builder(token, areaTypeName);

	builder.withDescription("Some updated description");

	return builder.build();
    }

    @Override
    protected AreaType updateEntity(String token, AreaTypeCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateAreaType(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected AreaType deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteAreaType(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<AreaType> listEntities() throws SiteWhereException {
	AreaTypeSearchCriteria searchCriteria = new AreaTypeSearchCriteria(1, 100);
	return getClient().listAreaTypes(getTenatAuthentication(), searchCriteria);
    }

    // ------------------------------------------------------------------------
    // LABEL
    // ------------------------------------------------------------------------

    @Override
    protected byte[] getLabelForEntity(String token, String generatorId) throws SiteWhereException {
	return getClient().getLabelForAreaType(getTenatAuthentication(), token, generatorId);
    }

}
