
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.tenant;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.search.tenant.TenantSearchCriteria;
import com.sitewhere.rest.model.tenant.Tenant;
import com.sitewhere.rest.model.tenant.request.TenantCreateRequest;
import com.sitewhere.spi.SiteWhereException;

/**
 *
 * @author Jorge Villaverde
 */
public class TenantRestTests extends AbstractCRUDRestClientTests<Tenant, TenantCreateRequest>{

    @Override
    protected String knownEntityToken() {
	return "workarea";
    }
    
    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected TenantCreateRequest buildCreateRequest(String token) throws SiteWhereException {
	String name = "test tenant";
	String authenticationToken = "tenant01";
	String logoUrl = "https://s3.amazonaws.com/sitewhere-demo/broken-link.png";
	String tenantTemplateId = "mongodb";
	String datasetTemplateId = "construction";
	TenantCreateRequest.Builder builder = new TenantCreateRequest.Builder(token, name, authenticationToken, logoUrl, tenantTemplateId,
		datasetTemplateId);
	
	builder.withAuthorizedUserId("admin");
	
	return builder.build();
    }

    @Override
    protected Tenant createEntity(TenantCreateRequest createRequest) throws SiteWhereException {
	return getClient().createTenant(createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected Tenant findEntityByToken(String token) throws SiteWhereException {
	return getClient().getTenantByToken(token);
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected TenantCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	String name = "test tenant";
	String authenticationToken = "tenant01";
	String logoUrl = "https://s3.amazonaws.com/sitewhere-demo/broken-link.png";
	String tenantTemplateId = null;
	String datasetTemplateId = null;
	TenantCreateRequest.Builder builder = new TenantCreateRequest.Builder(token, name, authenticationToken, logoUrl, tenantTemplateId,
		datasetTemplateId);
	builder.withAuthorizedUserId("admin");
	return builder.build();
    }

    @Override
    protected Tenant updateEntity(String token, TenantCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateTenant(token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected Tenant deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteTenant(token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------
    
    @Override
    protected SearchResults<Tenant> listEntities() throws SiteWhereException {
	TenantSearchCriteria searchCriteria = new TenantSearchCriteria(0, 10);
	return getClient().listTenants(searchCriteria);
    }

}
