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
package com.sitewhere.rest.model.customer;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.spi.customer.ICustomer;

/**
 * Model object for customer information.
 */
@JsonInclude(Include.NON_NULL)
public class Customer extends BrandedEntity implements ICustomer {

    /** Serial version UID */
    private static final long serialVersionUID = -3637398272972673831L;

    /** Customer type id */
    private UUID customerTypeId;

    /** Parent customer id */
    private UUID parentId;

    /** Area name */
    private String name;

    /** Area description */
    private String description;

    /*
     * @see com.sitewhere.spi.customer.ICustomer#getCustomerTypeId()
     */
    @Override
    public UUID getCustomerTypeId() {
	return customerTypeId;
    }

    public void setCustomerTypeId(UUID customerTypeId) {
	this.customerTypeId = customerTypeId;
    }

    /*
     * @see com.sitewhere.spi.common.ITreeEntity#getParentId()
     */
    @Override
    public UUID getParentId() {
	return parentId;
    }

    public void setParentId(UUID parentId) {
	this.parentId = parentId;
    }

    /*
     * @see com.sitewhere.spi.customer.ICustomer#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.customer.ICustomer#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }
}
