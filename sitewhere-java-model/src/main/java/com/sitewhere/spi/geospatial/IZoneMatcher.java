/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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