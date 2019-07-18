/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.scheduling;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.scheduling.IScheduledJobSearchCriteria;

/**
 * Default implementation of {@link IScheduledJobSearchCriteria}.
 */
public class ScheduledJobSearchCriteria extends SearchCriteria implements IScheduledJobSearchCriteria {

    /**
     * Default constructor.
     */
    public ScheduledJobSearchCriteria() {
	super();
    }

    /**
     * @param pageNumber
     * @param pageSize
     */
    public ScheduledJobSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

}
