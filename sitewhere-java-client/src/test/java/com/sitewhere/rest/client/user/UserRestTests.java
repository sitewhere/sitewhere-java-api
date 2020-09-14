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

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.user.SiteWhereRole;
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
	request.setRoles(authorities);
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
	List<String> roles = new ArrayList<String>();
	roles.add(SiteWhereRole.ADMINISTER_TENANTS.getRoleName());
	request.setRoles(roles);
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
