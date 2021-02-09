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

import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.area.IAreaType;
import com.sitewhere.spi.area.request.IAreaTypeCreateRequest;

/**
 * Provides information needed to create an area type.
 */
public class AreaTypeCreateRequest extends BrandedEntityCreateRequest implements IAreaTypeCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 7654388850917582565L;

    /** Name */
    private String name;

    /** Description */
    private String description;

    /** List of contained area type tokens */
    private List<String> containedAreaTypeTokens;

    /*
     * @see com.sitewhere.spi.area.request.IAreaTypeCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.area.request.IAreaTypeCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.area.request.IAreaTypeCreateRequest#
     * getContainedAreaTypeTokens()
     */
    @Override
    public List<String> getContainedAreaTypeTokens() {
	return containedAreaTypeTokens;
    }

    public void setContainedAreaTypeTokens(List<String> containedAreaTypeTokens) {
	this.containedAreaTypeTokens = containedAreaTypeTokens;
    }

    public static class Builder {

	/** Request being built */
	private AreaTypeCreateRequest request = new AreaTypeCreateRequest();

	public Builder(IAreaType api) {
	    request.setToken(api.getToken());
	    request.setName(api.getName());
	    request.setDescription(api.getDescription());
	    request.setIcon(api.getIcon());
	    if (api.getMetadata() != null) {
		request.setMetadata(new HashMap<String, String>());
		request.getMetadata().putAll(api.getMetadata());
	    }
	}

	public Builder(String token, String name) {
	    request.setToken(token);
	    request.setName(name);
	    request.setDescription("");
	    request.setIcon("fa-question");
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withImageUrl(String imageUrl) {
	    request.setImageUrl(imageUrl);
	    return this;
	}

	public Builder withIcon(String icon) {
	    request.setIcon(icon);
	    return this;
	}

	public Builder withContainedAreaType(String areaTypeToken) {
	    if (request.getContainedAreaTypeTokens() == null) {
		request.setContainedAreaTypeTokens(new ArrayList<String>());
	    }
	    request.getContainedAreaTypeTokens().add(areaTypeToken);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public AreaTypeCreateRequest build() {
	    return request;
	}
    }
}