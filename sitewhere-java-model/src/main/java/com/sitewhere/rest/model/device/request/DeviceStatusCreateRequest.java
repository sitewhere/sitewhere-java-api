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
package com.sitewhere.rest.model.device.request;

import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.device.request.IDeviceStatusCreateRequest;

/**
 * Model object implementing {@link IDeviceStatusCreateRequest}.
 */
public class DeviceStatusCreateRequest extends PersistentEntityCreateRequest implements IDeviceStatusCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -1667891345754538713L;

    /** Default Background Color */
    public static final String DEFAULT_BACKGROUD_COLOR = "#FFFFFF";

    /** Default Foreground Color */
    public static final String DEFAULT_FOREGROUND_COLOR = "#000000";

    /** Default Border Color */
    public static final String DEFAULT_BORDER_COLOR = "#000000";

    /** Default Icon */
    public static final String DEFAULT_ICON = "fa-question";

    /** Token for device type */
    private String deviceTypeToken;

    /** Status code */
    private String code;

    /** Display name */
    private String name;

    /** Background color */
    private String backgroundColor;

    /** Foreground color */
    private String foregroundColor;

    /** Border color */
    private String borderColor;

    /** Icon */
    private String icon;

    /*
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#
     * getDeviceTypeToken()
     */
    @Override
    public String getDeviceTypeToken() {
	return deviceTypeToken;
    }

    public void setDeviceTypeToken(String deviceTypeToken) {
	this.deviceTypeToken = deviceTypeToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#getCode()
     */
    @Override
    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#
     * getBackgroundColor()
     */
    @Override
    public String getBackgroundColor() {
	return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#
     * getForegroundColor()
     */
    @Override
    public String getForegroundColor() {
	return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
	this.foregroundColor = foregroundColor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#
     * getBorderColor()
     */
    @Override
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.request.IDeviceStatusCreateRequest#getIcon()
     */
    @Override
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    public static Builder newBuilder() {
	return new Builder();
    }

    public static class Builder {

	private DeviceStatusCreateRequest build;

	private Builder() {
	    super();
	    this.build = new DeviceStatusCreateRequest();
	    withBackgroundColor(DEFAULT_BACKGROUD_COLOR);
	    withForegroundColor(DEFAULT_FOREGROUND_COLOR);
	    withBorderColor(DEFAULT_BORDER_COLOR);
	    withIcon(DEFAULT_ICON);
	}

	public Builder withToken(String token) {
	    this.build.setToken(token);
	    return this;
	}

	public Builder withDeviceTypeToken(String deviceTypeToken) {
	    this.build.setDeviceTypeToken(deviceTypeToken);
	    return this;
	}

	public Builder withCode(String code) {
	    this.build.setCode(code);
	    return this;
	}

	public Builder withName(String name) {
	    this.build.setName(name);
	    return this;
	}

	public Builder withBackgroundColor(String backgroundColor) {
	    this.build.setBackgroundColor(backgroundColor);
	    return this;
	}

	public Builder withForegroundColor(String foregroundColor) {
	    this.build.setForegroundColor(foregroundColor);
	    return this;
	}

	public Builder withBorderColor(String borderColor) {
	    this.build.setBorderColor(borderColor);
	    return this;
	}

	public Builder withIcon(String icon) {
	    this.build.setIcon(icon);
	    return this;
	}

	public DeviceStatusCreateRequest build() {
	    return this.build;
	}
    }
}