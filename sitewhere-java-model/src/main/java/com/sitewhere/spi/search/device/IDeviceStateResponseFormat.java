/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.device;

/**
 * Determines which content is returned for device state responses.
 *
 * @author Jorge Villaverde
 */
public interface IDeviceStateResponseFormat {

    /**
     * Indicates if area is included.
     * 
     * @return
     */
    public Boolean getIncludeArea();

    /**
     * Indicates if asset is included.
     * 
     * @return
     */
    public Boolean getIncludeAsset();
    
    /**
     * Indicates if customer is included.
     * 
     * @return
     */
    public Boolean getIncludeCustomer();
    
    /**
     * Indicates if device is included.
     * 
     * @return
     */
    public Boolean getIncludeDevice();

    /**
     * Indicates if device assignment is included.
     * 
     * @return
     */
    public Boolean getIncludeDeviceAssignment();

    /**
     * Indicates if device type is included.
     * 
     * @return
     */
    public Boolean getIncludeDeviceType();
    
    /**
     * Indicates if event details is included.
     * 
     * @return
     */
    public Boolean getIncludeEventDetails();

}
