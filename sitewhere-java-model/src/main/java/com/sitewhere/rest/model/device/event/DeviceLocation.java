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
package com.sitewhere.rest.model.device.event;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceLocation;

/**
 * Represents the location of a device at a moment in time.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceLocation extends DeviceEvent implements IDeviceLocation, Serializable {

    /** For Java serialization */
    private static final long serialVersionUID = -6279278445519407648L;

    /** Latitude value */
    private BigDecimal latitude;

    /** Longitude value */
    private BigDecimal longitude;

    /** Elevation value */
    private BigDecimal elevation;

    public DeviceLocation() {
	super(DeviceEventType.Location);
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceLocationContent#getLatitude()
     */
    @Override
    public BigDecimal getLatitude() {
	return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceLocationContent#getLongitude()
     */
    @Override
    public BigDecimal getLongitude() {
	return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
	this.longitude = longitude;
    }

    /*
     * @see com.sitewhere.spi.device.event.IDeviceLocationContent#getElevation()
     */
    @Override
    public BigDecimal getElevation() {
	return elevation;
    }

    public void setElevation(BigDecimal elevation) {
	this.elevation = elevation;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static DeviceLocation copy(IDeviceLocation input) throws SiteWhereException {
	DeviceLocation result = new DeviceLocation();
	DeviceEvent.copy(input, result);
	result.setLatitude(input.getLatitude());
	result.setLongitude(input.getLongitude());
	result.setElevation(input.getElevation());
	return result;
    }
}