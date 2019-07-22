
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
	builder.withFillColor("#FFCC00");
	builder.withBorderColor("#FFCCCC");
	builder.withOpacity(0.9);

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
	builder.withBorderColor("#FFCCCC");
	builder.withOpacity(0.8);
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
