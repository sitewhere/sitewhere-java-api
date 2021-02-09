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
package com.sitewhere.rest.client.device;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.area.Area;
import com.sitewhere.rest.model.area.Zone;
import com.sitewhere.rest.model.area.request.ZoneCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.device.ZoneSearchCriteria;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class ZoneRestTest extends AbstractCRUDRestClientTests<Zone, ZoneCreateRequest> {

    private String name = "Test Zone Name";

    private String areaToken = "peachtree";

    @Override
    protected String knownEntityToken() {
	return "officepark";
    }

    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------

    @Override
    protected ZoneCreateRequest buildCreateRequest(String token) throws SiteWhereException {
	Area area = getClient().getAreaByToken(getTenatAuthentication(), areaToken);
	ZoneCreateRequest.Builder builder = new ZoneCreateRequest.Builder(token, name, area);
	builder.withBorderColor("#FFCCCC");
	builder.withBorderOpacity(0.8);
	builder.withFillColor("#FFCC00");
	builder.withFillOpacity(0.9);

	return builder.build();
    }

    @Override
    protected Zone createEntity(ZoneCreateRequest createRequest) throws SiteWhereException {
	return getClient().createZone(getTenatAuthentication(), createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Zone findEntityByToken(String token) throws SiteWhereException {
	return getClient().getZoneByToken(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected ZoneCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	Area area = getClient().getAreaByToken(getTenatAuthentication(), areaToken);
	ZoneCreateRequest.Builder builder = new ZoneCreateRequest.Builder(token, name, area);
	builder.withFillColor("#FFCC00");
	builder.withBorderOpacity(0.7);
	builder.withBorderColor("#FFCCCC");
	builder.withFillOpacity(0.8);
	return builder.build();
    }

    @Override
    protected Zone updateEntity(String token, ZoneCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateZone(getTenatAuthentication(), token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Zone deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteZone(getTenatAuthentication(), token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------

    @Override
    protected SearchResults<Zone> listEntities() throws SiteWhereException {
	ZoneSearchCriteria searchCriteria = new ZoneSearchCriteria(0, 10);
	return getClient().listZones(getTenatAuthentication(), searchCriteria);
    }

}
