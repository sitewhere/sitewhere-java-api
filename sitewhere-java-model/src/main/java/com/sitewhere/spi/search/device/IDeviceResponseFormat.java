/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

/**
 * Determines which content is returned for device responses.
 */
public interface IDeviceResponseFormat {

    /**
     * Indicates if device type information is included.
     * 
     * @return
     */
    Boolean getIncludeDeviceType();

    /**
     * Indicates if assignment information is included.
     * 
     * @return
     */
    Boolean getIncludeAssignment();
}
