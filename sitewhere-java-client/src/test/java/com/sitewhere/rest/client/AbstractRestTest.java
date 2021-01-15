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
package com.sitewhere.rest.client;

import org.junit.Before;

import com.sitewhere.spi.ISiteWhereClient;
import com.sitewhere.spi.ITenantAuthentication;
import com.sitewhere.spi.SiteWhereException;

/**
 * Base Tenant Test class.
 * 
 * @author Jorge Villaverde
 */
public abstract class AbstractRestTest {

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
