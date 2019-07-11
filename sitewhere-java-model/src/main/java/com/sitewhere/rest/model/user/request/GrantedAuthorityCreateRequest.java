/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user.request;

import com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest;

/**
 * Default implementation of {@link IGrantedAuthorityCreateRequest} for use in REST
 * services.
 * @author Jorge Villaverde
 */
public class GrantedAuthorityCreateRequest implements IGrantedAuthorityCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -2388892324819108444L;

    /** Authority name */
    private String authority;
    
    /** Description of the authority */
    private String description;
    
    /** Parent authority */
    private String parent;
    
    /** Indicates if it's a group of authorities */
    private boolean group;

    /*
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getAuthority()
     */
    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /*
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getParent()
     */
    @Override
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    /*
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#isGroup()
     */
    @Override
    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }
}
