/**
 * Copyright © 2014-2021 The SiteWhere Authors
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