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
import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.area.request.IAreaCreateRequest;

/**
 * Provides parameters needed to create a new area.
 */
@JsonInclude(Include.NON_NULL)
public class AreaCreateRequest extends BrandedEntityCreateRequest implements IAreaCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 2232101100201358496L;

    /** Area type token */
    public String areaTypeToken;

    /** Parent area token */
    public String parentToken;

    /** Site name */
    private String name;

    /** Site description */
    private String description;

    /** Locations that define area boundaries */
    private List<Location> bounds = new ArrayList<Location>();

    /*
     * @see com.sitewhere.spi.area.request.IAreaCreateRequest#getAreaTypeToken()
     */
    @Override
    public String getAreaTypeToken() {
	return areaTypeToken;
    }

    public void setAreaTypeToken(String areaTypeToken) {
	this.areaTypeToken = areaTypeToken;
    }

    /*
     * @see
     * com.sitewhere.spi.common.request.ITreeEntityCreateRequest#getParentToken()
     */
    @Override
    public String getParentToken() {
	return parentToken;
    }

    public void setParentToken(String parentToken) {
	this.parentToken = parentToken;
    }

    /*
     * @see com.sitewhere.spi.area.request.IAreaCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.area.request.IAreaCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.area.request.IAreaCreateRequest#getBounds()
     */
    @Override
    public List<Location> getBounds() {
	return bounds;
    }

    public void setBounds(List<Location> bounds) {
	this.bounds = bounds;
    }

    public static class Builder {

	/** Request being built */
	private AreaCreateRequest request = new AreaCreateRequest();

	public Builder(String areaTypeToken, String parentToken, String token, String name) {
	    request.setAreaTypeToken(areaTypeToken);
	    request.setParentToken(parentToken);
	    request.setToken(token);
	    request.setName(name);
	    request.setDescription("");
	    request.setImageUrl("https://s3.amazonaws.com/sitewhere-demo/broken-link.png");
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withImageUrl(String imageUrl) {
	    request.setImageUrl(imageUrl);
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

	public AreaCreateRequest build() {
	    return request;
	}
    }
}