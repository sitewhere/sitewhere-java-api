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
package com.sitewhere.rest.model.common;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.common.ILocation;

/**
 * Model object for a location in 3d space.
 */
public class Location implements ILocation {

    /** Serial version UID */
    private static final long serialVersionUID = 7247443984993993837L;

    /** Latitude measurement */
    private Double latitude;

    /** Longitude measurement */
    private Double longitude;

    /** Elevation measurement */
    private Double elevation;

    public Location() {
    }

    public Location(Double latitude, Double longitude) {
	this.latitude = latitude;
	this.longitude = longitude;
	this.elevation = 0.0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.common.ILocation#getLatitude()
     */
    public Double getLatitude() {
	return latitude;
    }

    public void setLatitude(Double latitude) {
	this.latitude = latitude;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.common.ILocation#getLongitude()
     */
    public Double getLongitude() {
	return longitude;
    }

    public void setLongitude(Double longitude) {
	this.longitude = longitude;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.common.ILocation#getElevation()
     */
    public Double getElevation() {
	return elevation;
    }

    public void setElevation(Double elevation) {
	this.elevation = elevation;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static Location copy(ILocation input) {
	Location result = new Location();
	result.setLatitude(input.getLatitude());
	result.setLongitude(input.getLongitude());
	result.setElevation(input.getElevation());
	return result;
    }

    /**
     * Copy a list of locations from SPI to model.
     * 
     * @param input
     * @return
     */
    public static List<Location> copy(List<? extends ILocation> input) {
	if ((input == null) || (input.size() == 0)) {
	    return null;
	}
	List<Location> result = new ArrayList<>();
	for (ILocation location : input) {
	    result.add(Location.copy(location));
	}
	return result;
    }
}