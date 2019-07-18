/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user.request;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.user.AccountStatus;
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

    /** User status */
    private AccountStatus status;

    /** User authorities */
    private List<String> authorities;

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
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getStatus()
     */
    @Override
    public AccountStatus getStatus() {
	return status;
    }

    public void setStatus(AccountStatus status) {
	this.status = status;
    }

    /*
     * @see com.sitewhere.spi.user.request.IUserCreateRequest#getAuthorities()
     */
    @Override
    public List<String> getAuthorities() {
	return Collections.unmodifiableList(this.authorities);
    }

    public void setAuthorities(List<String> authorities) {
	this.authorities = authorities;
    }
}
