/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.customer;

/**
 * Determines which content is returned for customer responses.
 */
public interface ICustomerResponseFormat {

    /**
     * Indicates if customer type is to be returned.
     * 
     * @return
     */
    Boolean getIncludeCustomerType();
}
