/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.client;

import org.junit.Before;

import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.ITenantAuthentication;
import com.sitewhere.spi.SiteWhereException;

/**
 * Base Tenant Test class.
 * @author Jorge Villaverde
 */
public abstract class AbstractRestClient {

    /** SiteWhere Client */
    private ISiteWhereClient client;

    /** Tenant Authentication */
    private ITenantAuthentication tenantAuthentication;

    @Before
    public void init() throws SiteWhereException {
	this.client = SiteWhereClient.newBuilder().build().initialize();
	this.tenantAuthentication = SiteWhereClient.defaultTenant();
    }

    // Getters/Setters --------------------------------------------------------
    
    protected ISiteWhereClient getClient() {
	return client;
    }
   
    protected ITenantAuthentication getTenatAuthentication() {
	return tenantAuthentication;
    }

}
