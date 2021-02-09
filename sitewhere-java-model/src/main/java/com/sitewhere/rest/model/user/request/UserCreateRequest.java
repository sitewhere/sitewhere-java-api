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
package com.sitewhere.rest.model.user.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.user.IRole;
import com.sitewhere.spi.user.IUser;
import com.sitewhere.spi.user.request.IUserCreateRequest;

/**
 * Default implementation of {@link IUserCreateRequest} for use in REST
 * services.
 */
@JsonInclude(Include.NON_NULL)
public class UserCreateRequest extends PersistentEntityCreateRequest implements IUserCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -735534954435737620L;

    /** Username */
    private String username;

    /** User password */
    private String password;

    /** User firstname */
    private String firstName;

    /** User lastname */
    private String lastName;

    /** User email */
    private String email;

    /** Enablement indicator */
    private boolean enabled;

    /** User authorities */
    private List<String> roles = new ArrayList<>();

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getUsername()
     */
    @Override
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getPassword()
     */
    @Override
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getFirstName()
     */
    @Override
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getLastName()
     */
    @Override
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getEmail()
     */
    @Override
    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#isEnabled()
     */
    @Override
    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getAuthorities()
     */
    @Override
    public List<String> getRoles() {
	return this.roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

    public static class Builder {

	/** Request being built */
	private UserCreateRequest request = new UserCreateRequest();

	public Builder(String username, String password, String firstName, String lastName) {
	    request.setUsername(username);
	    request.setPassword(password);
	    request.setFirstName(firstName);
	    request.setLastName(lastName);
	    request.setEnabled(true);
	}

	public Builder(IUser existing) {
	    request.setUsername(existing.getUsername());
	    request.setFirstName(existing.getFirstName());
	    request.setLastName(existing.getLastName());
	    request.setEnabled(existing.isEnabled());
	    request.setRoles(existing.getRoles().stream().map(IRole::getRole).collect(Collectors.toList()));
	    request.setMetadata(existing.getMetadata());
	}

	public Builder enabled() {
	    request.setEnabled(true);
	    return this;
	}

	public Builder disabled() {
	    request.setEnabled(false);
	    return this;
	}

	public Builder withRole(String role) {
	    if (request.getRoles() == null) {
		request.setRoles(new ArrayList<>());
	    }
	    request.getRoles().add(role);
	    return this;
	}

	public Builder withRoles(List<String> roles) {
	    if (request.getRoles() == null) {
		request.setRoles(new ArrayList<>());
	    }
	    request.getRoles().addAll(roles);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public UserCreateRequest build() {
	    return request;
	}
    }
}
