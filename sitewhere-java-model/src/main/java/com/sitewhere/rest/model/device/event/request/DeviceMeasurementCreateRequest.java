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

import java.math.BigDecimal;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.device.event.DeviceMeasurement;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.request.IDeviceMeasurementCreateRequest;

/**
 * Model object used to create a new {@link DeviceMeasurement} via REST APIs.
 */
@JsonIgnoreProperties
@JsonInclude(Include.NON_NULL)
public class DeviceMeasurementCreateRequest extends DeviceEventCreateRequest
	implements IDeviceMeasurementCreateRequest {

    /** Serialization version identifier */
    private static final long serialVersionUID = 9193083760712267587L;

    /** Measurement name */
    private String name;

    /** Measurement value */
    private BigDecimal value;

    public DeviceMeasurementCreateRequest() {
	setEventType(DeviceEventType.Measurement);
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceMeasurementCreateRequest#
     * getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.device.event.request.IDeviceMeasurementCreateRequest#
     * getValue()
     */
    @Override
    public BigDecimal getValue() {
	return value;
    }

    public void setValue(BigDecimal value) {
	this.value = value;
    }

    public static class Builder extends DeviceEventCreateRequest.Builder<DeviceMeasurementCreateRequest> {

	private DeviceMeasurementCreateRequest request = new DeviceMeasurementCreateRequest();

	public Builder() {
	}

	public Builder measurement(String name, double value) {
	    request.setName(name);
	    request.setValue(new BigDecimal(value));
	    return this;
	}

	public Builder measurement(String name, BigDecimal value) {
	    request.setName(name);
	    request.setValue(value);
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
	public DeviceMeasurementCreateRequest getRequest() {
	    return request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sitewhere.rest.model.device.event.request.
	 * DeviceEventCreateRequest.Builder# build()
	 */
	@Override
	public DeviceMeasurementCreateRequest build() {
	    return request;
	}
    }
}