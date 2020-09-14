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
package com.sitewhere.rest.model.asset.request;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.asset.AssetCategory;
import com.sitewhere.spi.asset.request.IAssetTypeCreateRequest;

/**
 * REST model implementation of {@link IAssetTypeCreateRequest}.
 */
@JsonInclude(Include.NON_NULL)
public class AssetTypeCreateRequest extends BrandedEntityCreateRequest implements IAssetTypeCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 4980888004733279548L;

    /** Name */
    private String name;

    /** Description */
    private String description;

    /** Asset category */
    private AssetCategory assetCategory;

    /*
     * @see com.sitewhere.spi.asset.request.IAssetTypeCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.asset.request.IAssetTypeCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see
     * com.sitewhere.spi.asset.request.IAssetTypeCreateRequest#getAssetCategory()
     */
    @Override
    public AssetCategory getAssetCategory() {
	return assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory) {
	this.assetCategory = assetCategory;
    }

    public static class Builder {

	/** Request being built */
	private AssetTypeCreateRequest request = new AssetTypeCreateRequest();

	public Builder(String token, String name) {
	    request.setToken(token);
	    request.setName(name);
	    request.setAssetCategory(AssetCategory.Hardware);
	    request.setImageUrl("https://s3.amazonaws.com/sitewhere-demo/broken-link.png");
	}

	public Builder asHardware() {
	    request.setAssetCategory(AssetCategory.Hardware);
	    return this;
	}

	public Builder asPerson() {
	    request.setAssetCategory(AssetCategory.Person);
	    return this;
	}

	public Builder asDevice() {
	    request.setAssetCategory(AssetCategory.Device);
	    return this;
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withImageUrl(String imageUrl) {
	    request.setImageUrl(imageUrl);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public AssetTypeCreateRequest build() {
	    return request;
	}
    }
}