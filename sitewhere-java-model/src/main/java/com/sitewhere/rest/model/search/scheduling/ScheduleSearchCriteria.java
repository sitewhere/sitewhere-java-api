/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.scheduling;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.scheduling.IScheduleSearchCriteria;

/**
 * Default implementation of {@link IScheduleSearchCriteria}.
 */
public class ScheduleSearchCriteria extends SearchCriteria implements IScheduleSearchCriteria {

    public ScheduleSearchCriteria() {
	super();
    }

    public ScheduleSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

}
