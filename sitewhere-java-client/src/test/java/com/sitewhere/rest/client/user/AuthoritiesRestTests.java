/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractRestTest;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.rest.model.user.GrantedAuthorityHierarchyNode;
import com.sitewhere.rest.model.user.request.GrantedAuthorityCreateRequest;
import com.sitewhere.spi.SiteWhereException;

/**
 * Authorities API tests.
 * @author Jorge Villaverde
 */
public class AuthoritiesRestTests extends AbstractRestTest {

    @Test
    public void testListAutorities() throws SiteWhereException {
	SearchResults<GrantedAuthority> auths = getClient().listAuthorities(getTenatAuthentication());
	assertNotNull(auths);
    }
    
    @Test
    public void testGetAutorityByName() throws SiteWhereException {
	GrantedAuthority auth = getClient().getAuthorityByName(getTenatAuthentication(), "GRP_SERVER");
	assertNotNull(auth);
    }

    @Test
    public void testCreateAutority() throws SiteWhereException {
	GrantedAuthorityCreateRequest request = new GrantedAuthorityCreateRequest();
	
	request.setAuthority(UUID.randomUUID().toString());
	request.setDescription("Some description");
	request.setGroup(false);
	
	GrantedAuthority auth = getClient().createAuthority(getTenatAuthentication(), request);
	assertNotNull(auth);
    }

    @Test
    public void testAutorityHierarchy() throws SiteWhereException {
	List<GrantedAuthorityHierarchyNode> hierarchy = getClient().getAuthoritiesHierarchy(getTenatAuthentication());
	assertNotNull(hierarchy);
    }
}
