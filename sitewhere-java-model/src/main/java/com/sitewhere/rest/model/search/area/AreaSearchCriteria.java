/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.area;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.area.IAreaSearchCriteria;

/**
 * Model object for properties used in area searches.
 * 
 * @author Derek
 */
public class AreaSearchCriteria extends SearchCriteria implements IAreaSearchCriteria {

    /** Only return areas of the given type */
    private String areaTypeToken;

    /** Only return areas with the given parent */
    private String parentAreaToken;

    public AreaSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getAreaTypeToken()
     */
    @Override
    public String getAreaTypeToken() {
	return areaTypeToken;
    }

    public void setAreaTypeToken(String areaTypeToken) {
	this.areaTypeToken = areaTypeToken;
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getParentAreaToken()
     */
    @Override
    public String getParentAreaToken() {
	return parentAreaToken;
    }

    public void setParentAreaToken(String parentAreaToken) {
	this.parentAreaToken = parentAreaToken;
    }
}
