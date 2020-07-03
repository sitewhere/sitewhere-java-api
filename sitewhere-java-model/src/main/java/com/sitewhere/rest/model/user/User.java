/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.user.AccountStatus;
import com.sitewhere.spi.user.IRole;
import com.sitewhere.spi.user.IUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Model class for a User.
 */
@JsonInclude(Include.NON_NULL)
public class User extends PersistentEntity implements IUser {

    /** For {@link Serializable} */
    private static final long serialVersionUID = -3322129570954465956L;

    /** Unique username */
    private String username;

    /** Hashed password */
    private String hashedPassword;

    /** First name */
    private String firstName;

    /** Last name */
    private String lastName;

    /** Last login */
    private Date lastLogin;

    /** Account status */
    private AccountStatus status;

    /** List of roles */
    @JsonIgnore
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
     * @see com.sitewhere.spi.user.IUser#getHashedPassword()
     */
    @Override
    public String getHashedPassword() {
	return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
	this.hashedPassword = hashedPassword;
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
     * @see com.sitewhere.spi.user.IUser#getLastLogin()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getLastLogin() {
	return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
	this.lastLogin = lastLogin;
    }

    /*
     * @see com.sitewhere.spi.user.IUser#getStatus()
     */
    @Override
    public AccountStatus getStatus() {
	return status;
    }

    public void setStatus(AccountStatus status) {
	this.status = status;
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
	result.setHashedPassword(input.getHashedPassword());
	result.setFirstName(input.getFirstName());
	result.setLastName(input.getLastName());
	result.setLastLogin(input.getLastLogin());
	result.setStatus(input.getStatus());
	result.setRoles(new ArrayList<>(input.getRoles()));
	PersistentEntity.copy(input, result);
	return result;
    }
}