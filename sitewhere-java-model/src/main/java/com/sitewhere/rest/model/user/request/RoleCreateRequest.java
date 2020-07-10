/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user.request;
import com.sitewhere.spi.user.request.IRoleCreateRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Default implementation of {@link IRoleCreateRequest} for use in
 * REST services.
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
     * @see
     * com.sitewhere.spi.user.request.IRoleCreateRequest#getRole()
     */
    @Override
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /*
     * @see
     * com.sitewhere.spi.user.request.IRoleCreateRequest#getDescription()
     */
    @Override public String getDescription() {
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
