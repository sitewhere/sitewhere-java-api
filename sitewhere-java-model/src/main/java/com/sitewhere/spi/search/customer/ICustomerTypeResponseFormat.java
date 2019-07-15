/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.search.customer;

/**
 * Determines which content is returned for customer type responses.
 * 
 * @author Jorge Villaverde
 */
public interface ICustomerTypeResponseFormat {
    
    /**
     * Indicates if contained customer types are to be returned.
     * 
     * @return
     */
    public Boolean getIncludeContainedCustomerTypes();

}
