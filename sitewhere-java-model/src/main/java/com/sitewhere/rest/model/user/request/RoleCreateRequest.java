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

import com.sitewhere.spi.user.request.IRoleCreateRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of {@link IRoleCreateRequest} for use in REST
 * services.
 */
public class RoleCreateRequest implements IRoleCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -2388892324819108444L;

    /** Role name */
    private String role;

    /** Description of the authority */
    private String description;

    /** List of granted authorities */
    private List<String> authorities = new ArrayList<>();

    /*
     * @see com.sitewhere.spi.user.request.IRoleCreateRequest#getRole()
     */
    @Override
    public String getRole() {
	return this.role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    /*
     * @see com.sitewhere.spi.user.request.IRoleCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return this.description;
    }

    @Override
    public List<String> getAuthorities() {
	return this.authorities;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setAuthorities(List<String> authorities) {
	this.authorities = authorities;
    }
}
