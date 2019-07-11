/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sitewhere.rest.client.AbstractRestClient;
import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.user.GrantedAuthority;
import com.sitewhere.spi.SiteWhereException;

/**
 * Authorities API tests.
 * @author Jorge Villaverde
 */
public class AuthoritiesRestTest extends AbstractRestClient {

    @Test
    public void testListAutorities() throws SiteWhereException {
	SearchResults<GrantedAuthority> auths = getClient().listAuthorities(getTenatAuthentication());
	assertNotNull(auths);
    }
    
}
