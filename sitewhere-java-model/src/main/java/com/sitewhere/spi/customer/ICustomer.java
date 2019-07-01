/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.customer;

import java.util.UUID;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.IBrandedTreeEntity;

/**
 * An entity that represents a customer (device owner) based on a previously
 * defined customer type.
 */
public interface ICustomer extends IBrandedTreeEntity, IAccessible {

    /**
     * Get id of corresponding customer type.
     * 
     * @return
     */
    public UUID getCustomerTypeId();
}