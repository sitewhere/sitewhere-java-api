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
    
    /** Include Area Type */
    private Boolean includeAreaType;
    
    /** Include assignments */
    private Boolean includeAssignments;

    /** Include zones */
    private Boolean includeZones;
    
    /** Only return areas with the given parent */
    private String parentAreaToken;

    /** Only return root areas */
    private Boolean rootOnly;

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

    public void setAreaTypeTokeb(String areaTypeToken) {
	this.areaTypeToken = areaTypeToken;
    }

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
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeAssignments()
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
    
    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getRootOnly()
     */
    @Override
    public Boolean getRootOnly() {
	return rootOnly;
    }

    public void setRootOnly(Boolean rootOnly) {
	this.rootOnly = rootOnly;
    }
}
