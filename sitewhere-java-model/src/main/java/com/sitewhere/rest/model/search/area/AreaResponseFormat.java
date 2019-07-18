/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.area;

import com.sitewhere.spi.search.area.IAreaResponseFormat;

/**
 * Default implementation of {@link IAreaResponseFormat}.
 */
public class AreaResponseFormat implements IAreaResponseFormat {

    /** Include Area Type */
    private Boolean includeAreaType;

    /** Include assignments */
    private Boolean includeAssignments;

    /** Include zones */
    private Boolean includeZones;

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeAreaType()
     */
    @Override
    public Boolean getIncludeAreaType() {
	return includeAreaType;
    }

    public void setIncludeAreaType(Boolean includeAreaType) {
	this.includeAreaType = includeAreaType;
    }

    /*
     * @see
     * com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeAssignments()
     */
    @Override
    public Boolean getIncludeAssignments() {
	return includeAssignments;
    }

    public void setIncludeAssignments(Boolean includeAssignments) {
	this.includeAssignments = includeAssignments;
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeZones()
     */
    @Override
    public Boolean getIncludeZones() {
	return includeZones;
    }

    public void setIncludeZones(Boolean includeZones) {
	this.includeZones = includeZones;
    }
}
