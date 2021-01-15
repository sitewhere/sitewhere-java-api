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
package com.sitewhere.rest.model.device;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.device.IDevice;
import com.sitewhere.spi.device.IDeviceElementMapping;

/**
 * Model implementation of {@link IDeviceElementMapping}.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceElementMapping implements IDeviceElementMapping {

    /** Serialization version identifier */
    private static final long serialVersionUID = 2668063520841302094L;

    /** Path in device element schema being mapped */
    private String deviceElementSchemaPath;

    /** Token of device being mapped */
    private String deviceToken;

    /** FIELDS BELOW DEPEND ON MARSHALING PARAMETERS */

    /** Device info if populated by marshaller */
    private IDevice device;

    public DeviceElementMapping() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sitewhere.spi.device.IDeviceElementMapping#getDeviceElementSchemaPath ()
     */
    @Override
    public String getDeviceElementSchemaPath() {
	return deviceElementSchemaPath;
    }

    public void setDeviceElementSchemaPath(String deviceElementSchemaPath) {
	this.deviceElementSchemaPath = deviceElementSchemaPath;
    }

    /*
     * @see com.sitewhere.spi.device.IDeviceElementMapping#getDeviceToken()
     */
    @Override
    public String getDeviceToken() {
	return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
	this.deviceToken = deviceToken;
    }

    public IDevice getDevice() {
	return device;
    }

    public void setDevice(IDevice device) {
	this.device = device;
    }

    public static DeviceElementMapping copy(IDeviceElementMapping input) {
	DeviceElementMapping result = new DeviceElementMapping();
	result.setDeviceElementSchemaPath(input.getDeviceElementSchemaPath());
	result.setDeviceToken(input.getDeviceToken());
	return result;
    }
}