/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Criteria used for filtering device commands.
 */
public interface IDeviceCommandSearchCriteria extends ISearchCriteria {

    /**
     * Limit results by device type id.
     * 
     * @return
     */
    String getDeviceTypeToken();
}