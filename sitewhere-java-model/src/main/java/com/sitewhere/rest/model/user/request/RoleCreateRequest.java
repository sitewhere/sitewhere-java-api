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

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.user.IGrantedAuthority;
import com.sitewhere.spi.user.IRole;
import com.sitewhere.spi.user.request.IRoleCreateRequest;

/**
 * Holds fields needed to create a new granted authority.
 */
@JsonInclude(Include.NON_NULL)
public class RoleCreateRequest implements IRoleCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 2752477482696017875L;

    /** Rol name */
    private String role;

    /** Role description */
    private String description;

    /** Role authorities */
    private List<String> authorities;

    @Override
    public String getRole() {
	return role;
    }

    @Override
    public String getDescription() {
	return description;
    }

    @Override
    public List<String> getAuthorities() {
	return authorities;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setAuthorities(List<String> authorities) {
	this.authorities = authorities;
    }

    public static class Builder {
	/** Request being built */
	private RoleCreateRequest request = new RoleCreateRequest();

	public Builder(String role) {
	    request.setRole(role);
	}

	public Builder(IRole existing) {
	    request.setRole(existing.getRole());
	    request.setDescription(existing.getDescription());
	    request.setAuthorities(existing.getAuthorities().stream().map(IGrantedAuthority::getAuthority)
		    .collect(Collectors.toList()));
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withAuthority(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withAuthorities(List<String> authorities) {
	    request.setAuthorities(authorities);
	    return this;
	}

	public RoleCreateRequest build() {
	    return request;
	}
    }
}