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
package com.sitewhere.rest.model.search.customer;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.customer.ICustomerSearchCriteria;

/**
 * Model object for properties used in customer searches.
 */
public class CustomerSearchCriteria extends SearchCriteria implements ICustomerSearchCriteria {

    /** Only return root customers */
    private Boolean rootOnly;

    /** Only return customers with the given parent */
    private String parentCustomerToken;

    /** Only return customers of the given type */
    private String customerTypeToken;

    public CustomerSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerSearchCriteria#getRootOnly()
     */
    @Override
    public Boolean getRootOnly() {
	return rootOnly;
    }

    public void setRootOnly(Boolean rootOnly) {
	this.rootOnly = rootOnly;
    }

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerSearchCriteria#
     * getParentCustomerToken ()
     */
    @Override
    public String getParentCustomerToken() {
	return parentCustomerToken;
    }

    public void setParentCustomerToken(String parentCustomerToken) {
	this.parentCustomerToken = parentCustomerToken;
    }

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerSearchCriteria#
     * getCustomerTypeToken()
     */
    @Override
    public String getCustomerTypeToken() {
	return customerTypeToken;
    }

    public void setCustomerTypeToken(String customerTypeToken) {
	this.customerTypeToken = customerTypeToken;
    }

}
