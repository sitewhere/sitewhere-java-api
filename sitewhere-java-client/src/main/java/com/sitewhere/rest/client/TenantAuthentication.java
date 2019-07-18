/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import com.sitewhere.spi.ITenantAuthentication;

/**
 * Model object for passing tenant authentication information.
 */
public class TenantAuthentication implements ITenantAuthentication {

    /** Tenant token */
    private String tenantToken;

    /** Tenant authentication token */
    private String tenantAuthToken;

    /*
     * @see com.sitewhere.spi.ITenantAuthentication#getTenantToken()
     */
    @Override
    public String getTenantToken() {
	return tenantToken;
    }

    public void setTenantToken(String tenantToken) {
	this.tenantToken = tenantToken;
    }

    /*
     * @see com.sitewhere.spi.ITenantAuthentication#getTenantAuthToken()
     */
    @Override
    public String getTenantAuthToken() {
	return tenantAuthToken;
    }

    public void setTenantAuthToken(String tenantAuthToken) {
	this.tenantAuthToken = tenantAuthToken;
    }
}
