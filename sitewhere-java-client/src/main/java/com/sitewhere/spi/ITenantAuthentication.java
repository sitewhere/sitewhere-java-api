/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi;

/**
 * Provides tenant authentication information.
 */
public interface ITenantAuthentication {

    /**
     * Get token that identifies tenant.
     * 
     * @return
     */
    public String getTenantToken();

    /**
     * Get token for tenant authentication.
     * 
     * @return
     */
    public String getTenantAuthToken();
}
