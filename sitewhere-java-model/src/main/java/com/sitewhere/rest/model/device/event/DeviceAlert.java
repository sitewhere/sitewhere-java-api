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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.event.AlertLevel;
import com.sitewhere.spi.device.event.AlertSource;
import com.sitewhere.spi.device.event.DeviceEventType;
import com.sitewhere.spi.device.event.IDeviceAlert;

/**
 * Model object for an alert event from a remote device.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceAlert extends DeviceEvent implements IDeviceAlert, Serializable {

    /** For Java serialization */
    private static final long serialVersionUID = 594540716893472520L;

    /** Alert source */
    private AlertSource source;

    /** Alert level */
    private AlertLevel level;

    /** Alert type */
    private String type;

    /** Alert message */
    private String message;

    public DeviceAlert() {
	super(DeviceEventType.Alert);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceAlert#getSource()
     */
    public AlertSource getSource() {
	return source;
    }

    public void setSource(AlertSource source) {
	this.source = source;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceAlert#getLevel()
     */
    public AlertLevel getLevel() {
	return level;
    }

    public void setLevel(AlertLevel level) {
	this.level = level;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceAlert#getType()
     */
    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.IDeviceAlert#getMessage()
     */
    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static DeviceAlert copy(IDeviceAlert input) throws SiteWhereException {
	DeviceAlert result = new DeviceAlert();
	DeviceEvent.copy(input, result);
	result.setSource(input.getSource());
	result.setType(input.getType());
	result.setMessage(input.getMessage());
	result.setLevel(input.getLevel());
	return result;
    }
}