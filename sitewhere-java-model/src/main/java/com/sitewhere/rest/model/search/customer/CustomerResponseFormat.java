/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.customer;

import com.sitewhere.spi.search.customer.ICustomerResponseFormat;

/**
 * Default implementation of {@ ICustomerResponseFormat}.
 * 
 * @author Jorge Villaverde
 */
public class CustomerResponseFormat implements ICustomerResponseFormat {

    /** Indicates if customer type is to be returned */
    private Boolean includeCustomerType;

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerResponseFormat#
     * getIncludeCustomerType()
     */
    @Override
    public Boolean getIncludeCustomerType() {
	return includeCustomerType;
    }

    public void setIncludeCustomerType(Boolean includeCustomerType) {
	this.includeCustomerType = includeCustomerType;
    }

}
