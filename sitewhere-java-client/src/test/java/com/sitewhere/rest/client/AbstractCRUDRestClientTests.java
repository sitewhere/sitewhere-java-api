/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.ITenantAuthentication;
import com.sitewhere.spi.SiteWhereException;

/**
 * @author Jorge Villaverde
 *
 */
public abstract class AbstractCRUDRestClientTests<T extends PersistentEntity, CR extends PersistentEntityCreateRequest> {
    
    /** SiteWhere Client */
    private ISiteWhereClient client;
    
    /** Tenant Authentication */
    private ITenantAuthentication tenantAuthentication;

    /** Entity token */
    private String token = UUID.randomUUID().toString();
    
    /** Entity */
    private T entity;

    @Before
    public void init() throws SiteWhereException {
	this.client = SiteWhereClient.newBuilder().build().initialize();
	this.tenantAuthentication = SiteWhereClient.defaultTenant();
    }

    // Tests ------------------------------------------------------------------
    
    @Test
    public void testCRUDEntity() throws SiteWhereException {
	CR createRequest = buildCreateRequest(token);
	
	this.entity = createEntity(createRequest);
	
	assertNotNull("Entity is null", entity);

	T foundEntity = findEntityByToken(token);
	
	assertEquals("Entity are not equals", 
		this.entity.getToken(), 
		foundEntity.getToken());
	
	CR updateRequest = buildUpdateRequest(token);
	
	T updatedEntity = updateEntity(token, updateRequest);
	
	assertNotNull("Updated entity is null", updatedEntity);
	
	T deleteEntity = deleteEntity(token);

	assertNotNull("Deleted entity is null", deleteEntity);
    }
    
    @Test
    public void testList() throws SiteWhereException {
	SearchResults<? extends T> results = listEntities();
	assertNotNull(results);
	assertNotEquals(0, results.getNumResults());
    }
    
    // Getters/Setters --------------------------------------------------------
    
    protected ISiteWhereClient getClient() {
	return client;
    }
   
    protected ITenantAuthentication getTenatAuthentication() {
	return tenantAuthentication;
    }
    
    // Abstract Methods -------------------------------------------------------
    
    protected abstract String knownEntityToken();
    
    protected abstract CR buildCreateRequest(String token);
    
    protected abstract T createEntity(CR createRequest) throws SiteWhereException;

    protected abstract T findEntityByToken(String token) throws SiteWhereException;

    protected abstract T updateEntity(String token, CR updateRequest) throws SiteWhereException;

    protected abstract CR buildUpdateRequest(String token) throws SiteWhereException;

    protected abstract T deleteEntity(String token) throws SiteWhereException;

    protected abstract SearchResults<? extends T> listEntities() throws SiteWhereException;
    
}
