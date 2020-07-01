/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user.request;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for arguments needed to create a role
 */
public interface IRoleCreateRequest extends Serializable {

    /**
     * Get the authority name.
     *
     * @return
     */
    public String getRole();

    /**
     * Get the description.
     *
     * @return
     */
    public String getDescription();

    /**
     * Get the list of granted authorities.
     *
     * @return
     */
    public List<String> getAuthorities();
}