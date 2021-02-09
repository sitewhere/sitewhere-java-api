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
package com.sitewhere.rest.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.user.IGrantedAuthority;
import com.sitewhere.spi.user.IRole;

import java.util.ArrayList;
import java.util.List;

/**
 * Model object for a rol.
 */
@JsonInclude(Include.NON_NULL)
public class Role implements IRole {

    /** Serial version UID */
    private static final long serialVersionUID = 872647555610555428L;

    /** Rol */
    private String role;

    /** Description */
    private String description;

    /** List of granted authorities */
    private List<IGrantedAuthority> authorities = new ArrayList<>();

    @Override
    public String getRole() {
	return this.role;
    }

    @Override
    public String getDescription() {
	return this.description;
    }

    @Override
    public List<IGrantedAuthority> getAuthorities() {
	return this.authorities;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setAuthorities(List<IGrantedAuthority> authorities) {
	this.authorities = authorities;
    }

    /**
     * Copy contents from the SPI class.
     *
     * @param input
     * @return
     */
    public static Role copy(IRole input) {
	Role result = new Role();
	result.setRole(input.getRole());
	result.setDescription(input.getDescription());
	result.setAuthorities(input.getAuthorities());
	return result;
    }
}