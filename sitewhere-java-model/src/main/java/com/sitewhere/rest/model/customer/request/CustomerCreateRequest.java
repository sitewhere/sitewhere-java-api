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

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest;
import com.sitewhere.spi.customer.request.ICustomerCreateRequest;

/**
 * Provides parameters needed to create a new customer.
 */
@JsonInclude(Include.NON_NULL)
public class CustomerCreateRequest extends BrandedEntityCreateRequest implements ICustomerCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -1744483793661325449L;

    /** Customer type token */
    public String customerTypeToken;

    /** Parent customer token */
    public String parentToken;

    /** Site name */
    private String name;

    /** Site description */
    private String description;

    /*
     * @see com.sitewhere.spi.customer.request.ICustomerCreateRequest#
     * getCustomerTypeToken()
     */
    @Override
    public String getCustomerTypeToken() {
	return customerTypeToken;
    }

    public void setCustomerTypeToken(String customerTypeToken) {
	this.customerTypeToken = customerTypeToken;
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
     * @see com.sitewhere.spi.customer.request.ICustomerCreateRequest#getName()
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
     * com.sitewhere.spi.customer.request.ICustomerCreateRequest#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public static class Builder {

	/** Request being built */
	private CustomerCreateRequest request = new CustomerCreateRequest();

	public Builder(String customerTypeToken, String parentToken, String token, String name) {
	    request.setCustomerTypeToken(customerTypeToken);
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

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public CustomerCreateRequest build() {
	    return request;
	}
    }
}
