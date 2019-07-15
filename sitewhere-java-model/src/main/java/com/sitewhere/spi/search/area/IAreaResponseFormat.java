/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.area;

/**
 * Determines which content is returned for areas.
 *
 * @author Jorge Villaverde
 */
public interface IAreaResponseFormat {

    /**
     * Indicates if included area type are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeAreaType();

    /**
     * Indicates if assignments are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeAssignments();

    /**
     * Indicates if zones are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeZones();
}
