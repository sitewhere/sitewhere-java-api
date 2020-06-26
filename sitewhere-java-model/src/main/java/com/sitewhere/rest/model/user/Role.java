/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.user.IRole;

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

    @Override
    public String getRole() {
	return this.role;
    }

    @Override
    public String getDescription() {
	return this.description;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public void setDescription(String description) {
	this.description = description;
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
	return result;
    }
}