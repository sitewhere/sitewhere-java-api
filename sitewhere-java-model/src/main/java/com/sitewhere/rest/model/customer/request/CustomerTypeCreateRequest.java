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
package com.sitewhere.rest.model.customer.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.customer.ICustomerType;
import com.sitewhere.spi.customer.request.ICustomerTypeCreateRequest;

/**
 * Provides information needed to create a customer type.
 */
public class CustomerTypeCreateRequest extends BrandedEntityCreateRequest implements ICustomerTypeCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 2776911532638550509L;

    /** Name */
    private String name;

    /** Description */
    private String description;

    /** List of contained customer type tokens */
    private List<String> containedCustomerTypeTokens;

    /*
     * @see com.sitewhere.spi.customer.request.ICustomerTypeCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see
     * com.sitewhere.spi.customer.request.ICustomerTypeCreateRequest#getDescription(
     * )
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.customer.request.ICustomerTypeCreateRequest#
     * getContainedCustomerTypeTokens()
     */
    @Override
    public List<String> getContainedCustomerTypeTokens() {
	return containedCustomerTypeTokens;
    }

    public void setContainedCustomerTypeTokens(List<String> containedCustomerTypeTokens) {
	this.containedCustomerTypeTokens = containedCustomerTypeTokens;
    }

    public static class Builder {

	/** Request being built */
	private CustomerTypeCreateRequest request = new CustomerTypeCreateRequest();

	public Builder(ICustomerType api) {
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

	public Builder withContainedCustomerType(String customerTypeToken) {
	    if (request.getContainedCustomerTypeTokens() == null) {
		request.setContainedCustomerTypeTokens(new ArrayList<String>());
	    }
	    request.getContainedCustomerTypeTokens().add(customerTypeToken);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public CustomerTypeCreateRequest build() {
	    return request;
	}
    }
}
