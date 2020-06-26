/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.tenant;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Search criteria for tenants.
 */
public interface ITenantSearchCriteria extends ISearchCriteria {

    /**
     * Get text search phrase to match against tenant id and name.
     * 
     * @return
     */
    String getTextSearch();

    /**
     * Search for tenants for which the given user is authorized.
     * 
     * @return
     */
    String getUserId();

    /**
     * Indicates whether runtime information should be included for the
     * corresponding tenant engine.
     * 
     * @return
     */
    boolean isIncludeRuntimeInfo();
}