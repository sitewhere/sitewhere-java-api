/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.customer;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.customer.ICustomerSearchCriteria;

/**
 * Model object for properties used in customer searches.
 * 
 * @author Derek
 */
public class CustomerSearchCriteria extends SearchCriteria implements ICustomerSearchCriteria {

    /** Only return customers with the given parent */
    private String parentCustomerToken;

    /** Only return customers of the given type */
    private String customerTypeToken;

    public CustomerSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see
     * com.sitewhere.spi.search.customer.ICustomerSearchCriteria#getParentCustomerToken
     * ()
     */
    @Override
    public String getParentCustomerToken() {
	return parentCustomerToken;
    }

    public void setParentCustomerToken(String parentCustomerToken) {
	this.parentCustomerToken = parentCustomerToken;
    }

    /*
     * @see
     * com.sitewhere.spi.search.customer.ICustomerSearchCriteria#getCustomerTypeToken()
     */
    @Override
    public String getCustomerTypeToken() {
	return customerTypeToken;
    }

    public void setCustomerTypeToken(String customerTypeToken) {
	this.customerTypeToken = customerTypeToken;
    }

}
