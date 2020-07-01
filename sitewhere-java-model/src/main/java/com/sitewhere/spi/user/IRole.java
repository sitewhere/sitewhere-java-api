/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for granted authority information.
 */
public interface IRole extends Serializable {

    /**
     * Get the rol name.
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