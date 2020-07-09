/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.user;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.user.IRoleSearchCriteria;

/**
 * Implementation of IRoleSearchCriteria.
 */
public class RoleSearchCriteria extends SearchCriteria implements IRoleSearchCriteria {

    /** Serial version UID */
    private static final long serialVersionUID = 3724218780869928660L;

    public RoleSearchCriteria() {
	super();
    }

    public RoleSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }
}