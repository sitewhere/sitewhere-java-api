/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.scheduling;

import com.sitewhere.spi.search.scheduling.IScheduledJobResponseFormat;

/**
 * Default implementation of {@link IScheduledJobResponseFormat}.
 * 
 * @author Jorge Villaverde
 */
public class ScheduledJobResponseFormat implements IScheduledJobResponseFormat {

    /** Indicates if context should be included in the response */
    private Boolean includeContext;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.rest.model.search.scheduling.ScheduledJobResponseFormat.
     * getIncludeContext()
     */
    @Override
    public Boolean getIncludeContext() {
	return includeContext;
    }

    public void setIncludeContext(Boolean includeContext) {
	this.includeContext = includeContext;
    }

}
