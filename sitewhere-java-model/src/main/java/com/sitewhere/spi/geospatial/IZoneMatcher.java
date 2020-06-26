/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.geospatial;

import java.util.Map;

import com.sitewhere.spi.device.event.IDeviceLocation;

/**
 * Contains results of matching a location against a list of zones.
 */
public interface IZoneMatcher {

    /**
     * Get location being matched.
     * 
     * @return
     */
    IDeviceLocation getLocation();

    /**
     * Get the map of all relationships.
     * 
     * @return
     */
    Map<String, IZoneRelationship> getRelationships();

    /**
     * Get relationship with the given zone.
     * 
     * @param zoneId
     * @return
     */
    IZoneRelationship getRelationship(String zoneId);
}