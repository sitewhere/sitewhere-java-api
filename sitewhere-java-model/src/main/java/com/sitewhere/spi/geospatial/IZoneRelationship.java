/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.geospatial;

import com.sitewhere.spi.area.IZone;
import com.sitewhere.spi.device.event.IDeviceLocation;

/**
 * Represents a relationship between a location and a zone.
 */
public interface IZoneRelationship {

    /**
     * Get device location.
     * 
     * @return
     */
    IDeviceLocation getLocation();

    /**
     * Get zone.
     * 
     * @return
     */
    IZone getZone();

    /**
     * Get containment indicator.
     * 
     * @return
     */
    ZoneContainment getContainment();
}