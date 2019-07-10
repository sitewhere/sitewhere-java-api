/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

/**
 * Determines which content is returned for device assignment responses.
 */
public interface IDeviceAssignmentResponseFormat {

    /**
     * Indicates if area is to be returned.
     * 
     * @return
     */
    public Boolean getIncludeArea();

    /**
     * Indicates if asset is to be returned.
     * 
     * @return
     */
    public Boolean getIncludeAsset();

    /**
     * Indicates if customer is to be returned.
     * 
     * @return
     */
    public Boolean getIncludeCustomer();

    /**
     * Indicates if device is to be returned.
     * 
     * @return
     */
    public Boolean getIncludeDevice();

    /**
     * Indicates if device type is to be returned.
     * 
     * @return
     */
    public Boolean getIncludeDeviceType();
}
