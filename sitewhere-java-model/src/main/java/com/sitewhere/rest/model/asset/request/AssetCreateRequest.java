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
import com.sitewhere.spi.asset.request.IAssetCreateRequest;

/**
 * REST model implementation of {@link IAssetCreateRequest}.
 */
@JsonInclude(Include.NON_NULL)
public class AssetCreateRequest extends BrandedEntityCreateRequest implements IAssetCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -3557255561907642778L;

    /** Asset type token */
    private String assetTypeToken;

    /** Asset name */
    private String name;

    /*
     * @see com.sitewhere.spi.asset.request.IAssetCreateRequest#getAssetTypeToken()
     */
    @Override
    public String getAssetTypeToken() {
	return assetTypeToken;
    }

    public void setAssetTypeToken(String assetTypeToken) {
	this.assetTypeToken = assetTypeToken;
    }

    /*
     * @see com.sitewhere.spi.asset.request.IAssetCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public static class Builder {

	/** Request being built */
	private AssetCreateRequest request = new AssetCreateRequest();

	public Builder(String token, String assetTypeToken, String name) {
	    request.setToken(token);
	    request.setAssetTypeToken(assetTypeToken);
	    request.setName(name);
	    request.setImageUrl("https://s3.amazonaws.com/sitewhere-demo/broken-link.png");
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

	public AssetCreateRequest build() {
	    return request;
	}
    }
}