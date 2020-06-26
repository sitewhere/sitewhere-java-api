/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.area;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Specifies criteria used to find matching areas.
 */
public interface IAreaSearchCriteria extends ISearchCriteria {

    /**
     * Indicates if only root elements are to be returned.
     * 
     * @return
     */
    Boolean getRootOnly();

    /**
     * Only match areas of the given type.
     * 
     * @return
     */
    String getAreaTypeToken();

    /**
     * Requires that areas have the given area as a parent.
     * 
     * @return
     */
    String getParentAreaToken();
}