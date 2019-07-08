/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.area;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.area.IAreaTypeSearchCriteria;

/**
 * Model object for properties used in area types searches.
 *
 * @author Jorge Villaverde
 */
public class AreaTypeSearchCriteria extends SearchCriteria implements IAreaTypeSearchCriteria {
    
    /** return contained area types */
    private Boolean includeContainedAreaTypes;


    public AreaTypeSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaTypeSearchCriteria#getIncludeContainedAreaTypes()
     */
    @Override
    public Boolean getIncludeContainedAreaTypes() {
	return includeContainedAreaTypes;
    }

    public void setIncludeContainedAreaTypes(Boolean includeContainedAreaTypes) {
        this.includeContainedAreaTypes = includeContainedAreaTypes;
    }

}
