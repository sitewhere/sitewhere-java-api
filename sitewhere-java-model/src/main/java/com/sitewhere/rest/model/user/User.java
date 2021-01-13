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
package com.sitewhere.rest.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.user.IRole;
import com.sitewhere.spi.user.IUser;

/**
 * Model class for a User.
 */
@JsonInclude(Include.NON_NULL)
public class User extends PersistentEntity implements IUser {

    /** For {@link Serializable} */
    private static final long serialVersionUID = -3322129570954465956L;

    /** Unique username */
    private String username;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Email address */
    private String email;

    /** Enabled indicator */
    private boolean enabled;

    /** List of roles */
    private List<IRole> roles = new ArrayList<>();

    /*
     * @see com.sitewhere.spi.user.IUser#getUsername()
     */
    @Override
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getFirstName()
     */
    @Override
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getLastName()
     */
    @Override
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getEmail()
     */
    @Override
    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#isEnabled()
     */
    @Override
    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getRoles()
     */
    @Override
    public List<IRole> getRoles() {
	return roles;
    }

    public void setRoles(List<IRole> roles) {
	this.roles = roles;
    }

    /**
     * Copy contents from the SPI class.
     *
     * @param input
     * @return
     */
    public static User copy(IUser input) throws SiteWhereException {
	User result = new User();
	result.setUsername(input.getUsername());
	result.setFirstName(input.getFirstName());
	result.setLastName(input.getLastName());
	result.setEmail(input.getEmail());
	result.setEnabled(input.isEnabled());
	result.setRoles(new ArrayList<>(input.getRoles()));
	PersistentEntity.copy(input, result);
	return result;
    }
}