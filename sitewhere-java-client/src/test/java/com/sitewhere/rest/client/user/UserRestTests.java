
/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.user;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractCRUDRestClientTests;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.rest.model.user.User;
import com.sitewhere.rest.model.user.request.UserCreateRequest;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.user.AccountStatus;

/**
 *
 * @author Jorge Villaverde
 *
 */
public class UserRestTests extends AbstractCRUDRestClientTests<User, UserCreateRequest> {

    private static final String JOHN_DOE_USERNAME = "johndoe";

    @Override
    protected String knownEntityToken() {
	return "admin";
    }
    
    // ------------------------------------------------------------------------
    // CREATE
    // ------------------------------------------------------------------------
    
    @Override
    protected UserCreateRequest buildCreateRequest(String token) throws SiteWhereException {
	UserCreateRequest request = new UserCreateRequest();
	request.setToken(token);
	request.setFirstName("John");
	request.setLastName("Doe");
	request.setStatus(AccountStatus.Active);
	request.setUsername(JOHN_DOE_USERNAME);
	request.setPassword("1234");
	List<String> authorities = new ArrayList<String>();
	authorities.add("GRP_SERVER");
	request.setAuthorities(authorities);
	return request;
    }
 
    protected String getToken() {
	return JOHN_DOE_USERNAME;
    }

    @Override
    protected User createEntity(UserCreateRequest createRequest) throws SiteWhereException {
	return getClient().createUser(createRequest);
    }

    // ------------------------------------------------------------------------
    // READ
    // ------------------------------------------------------------------------

    @Override
    protected User findEntityByToken(String token) throws SiteWhereException {
	return getClient().getUserByUsername("johndoe");
    }

    // ------------------------------------------------------------------------
    // UPDATE
    // ------------------------------------------------------------------------

    @Override
    protected UserCreateRequest buildUpdateRequest(String token) throws SiteWhereException {
	UserCreateRequest request = new UserCreateRequest();
	request.setToken(token);
	request.setFirstName("John");
	request.setLastName("Doe");
	request.setStatus(AccountStatus.Active);
	request.setUsername(JOHN_DOE_USERNAME);
	request.setPassword("12345");	
	List<String> authorities = new ArrayList<String>();
	authorities.add("GRP_SERVER");
	request.setAuthorities(authorities);
	return request;
    }

    @Override
    protected User updateEntity(String token, UserCreateRequest updateRequest) throws SiteWhereException {
	return getClient().updateUser(token, updateRequest);
    }

    // ------------------------------------------------------------------------
    // DELETE
    // ------------------------------------------------------------------------

    @Override
    protected User deleteEntity(String token) throws SiteWhereException {
	return getClient().deleteUser(token);
    }

    // ------------------------------------------------------------------------
    // LIST
    // ------------------------------------------------------------------------
    
    @Override
    protected SearchResults<User> listEntities() throws SiteWhereException {
	return getClient().listUsers();
    }
    
    @Test
    public void testListUserAuthorities() throws SiteWhereException {
	SearchResults<GrantedAuthority> auths = getClient().listUserAuthorities(knownEntityToken());
	assertNotNull(auths);
    }

}
