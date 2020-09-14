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
 * 
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
