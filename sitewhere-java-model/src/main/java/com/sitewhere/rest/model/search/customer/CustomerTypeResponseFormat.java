/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.search.customer;

import com.sitewhere.spi.search.customer.ICustomerTypeResponseFormat;

/**
 * Default implementation of {@link ICustomerTypeResponseFormat}.
 */
public class CustomerTypeResponseFormat implements ICustomerTypeResponseFormat {

    /** Include area detail */
    private Boolean includeContainedCustomerTypes;

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerTypeResponseFormat#
     * getIncludeContainedCustomerTypes()
     */
    public Boolean getIncludeContainedCustomerTypes() {
	return includeContainedCustomerTypes;
    }

    public void setIncludeContainedCustomerTypes(Boolean includeContainedCustomerTypes) {
	this.includeContainedCustomerTypes = includeContainedCustomerTypes;
    }

}
