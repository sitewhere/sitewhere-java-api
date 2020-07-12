/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.event.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.event.DeviceLocation;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest;

/**
 * Model object used to create a new {@link DeviceLocation} via REST APIs.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceLocationCreateRequest extends DeviceEventCreateRequest
	implements IDeviceLocationCreateRequest, Serializable {

    /** Serialization version identifier */
    private static final long serialVersionUID = -7160866457228082338L;

    /** Latitude value */
    private BigDecimal latitude;

    /** Longitude value */
    private BigDecimal longitude;

    /** Elevation value */
    private BigDecimal elevation;

    public DeviceLocationCreateRequest() {
	setEventType(DeviceEventType.Location);
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest#
     * getLatitude()
     */
    @Override
    public BigDecimal getLatitude() {
	return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest#
     * getLongitude()
     */
    @Override
    public BigDecimal getLongitude() {
	return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
	this.longitude = longitude;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceLocationCreateRequest#
     * getElevation()
     */
    @Override
    public BigDecimal getElevation() {
	return elevation;
    }

    public void setElevation(BigDecimal elevation) {
	this.elevation = elevation;
    }

    public static class Builder extends DeviceEventCreateRequest.Builder<DeviceLocationCreateRequest> {

	private DeviceLocationCreateRequest request = new DeviceLocationCreateRequest();

	public Builder(BigDecimal latitude, BigDecimal longitude) {
	    request.setLatitude(latitude);
	    request.setLongitude(longitude);
	    request.setElevation(BigDecimal.ZERO);
	}

	public Builder(double latitude, double longitude) {
	    request.setLatitude(new BigDecimal(latitude));
	    request.setLongitude(new BigDecimal(longitude));
	    request.setElevation(BigDecimal.ZERO);
	}

	public Builder withElevation(BigDecimal value) {
	    request.setElevation(value);
	    return this;
	}

	public Builder withElevation(double value) {
	    request.setElevation(new BigDecimal(value));
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.rest.model.device.event.request.
	 * DeviceEventCreateRequest.Builder# getRequest()
	 */
	@Override
	public DeviceLocationCreateRequest getRequest() {
	    return request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.rest.model.device.event.request.
	 * DeviceEventCreateRequest.Builder# build()
	 */
	@Override
	public DeviceLocationCreateRequest build() {
	    return request;
	}
    }
}