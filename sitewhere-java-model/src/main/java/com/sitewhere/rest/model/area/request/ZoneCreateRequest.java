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
package com.sitewhere.rest.model.area.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.Location;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.area.IArea;
import com.sitewhere.spi.area.request.IZoneCreateRequest;

/**
 * Provides parameters needed to create a new zone.
 */
@JsonInclude(Include.NON_NULL)
public class ZoneCreateRequest extends PersistentEntityCreateRequest implements IZoneCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -2226478978161539653L;

    /** Area token */
    private String areaToken;

    /** Zone name */
    private String name;

    /** Locations that define zone boundaries */
    private List<Location> bounds = new ArrayList<Location>();

    /** Border color in UI */
    private String borderColor;

    /** Border opacity */
    private Double borderOpacity;

    /** Fill color in UI */
    private String fillColor;

    /** Fill opacity */
    private Double fillOpacity;

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getAreaToken()
     */
    @Override
    public String getAreaToken() {
	return areaToken;
    }

    public void setAreaToken(String areaToken) {
	this.areaToken = areaToken;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getBounds()
     */
    @Override
    public List<Location> getBounds() {
	return bounds;
    }

    public void setBounds(List<Location> bounds) {
	this.bounds = bounds;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getBorderColor()
     */
    @Override
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getBorderOpacity()
     */
    @Override
    public Double getBorderOpacity() {
	return borderOpacity;
    }

    public void setBorderOpacity(Double borderOpacity) {
	this.borderOpacity = borderOpacity;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getFillColor()
     */
    @Override
    public String getFillColor() {
	return fillColor;
    }

    public void setFillColor(String fillColor) {
	this.fillColor = fillColor;
    }

    /*
     * @see com.sitewhere.spi.area.request.IZoneCreateRequest#getFillOpacity()
     */
    @Override
    public Double getFillOpacity() {
	return fillOpacity;
    }

    public void setFillOpacity(Double fillOpacity) {
	this.fillOpacity = fillOpacity;
    }

    public static class Builder {

	/** Request being built */
	private ZoneCreateRequest request = new ZoneCreateRequest();

	public Builder(String token, String name, IArea area) {
	    request.setToken(token);
	    request.setName(name);
	    request.setAreaToken(area.getToken());
	}

	public Builder withBorderColor(String borderColor) {
	    request.setBorderColor(borderColor);
	    return this;
	}

	public Builder withBorderOpacity(double opacity) {
	    request.setBorderOpacity(opacity);
	    return this;
	}

	public Builder withFillColor(String fillColor) {
	    request.setFillColor(fillColor);
	    return this;
	}

	public Builder withFillOpacity(double opacity) {
	    request.setFillOpacity(opacity);
	    return this;
	}

	public Builder coord(double latitude, double longitude) {
	    request.getBounds().add(new Location(latitude, longitude));
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public ZoneCreateRequest build() {
	    return request;
	}
    }
}