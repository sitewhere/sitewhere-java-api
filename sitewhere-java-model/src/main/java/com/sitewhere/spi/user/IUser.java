/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user;

import java.util.Date;
import java.util.List;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Interface for accessing user information.
 */
public interface IUser extends IPersistentEntity {

    /**
     * Get the username.
     * 
     * @return
     */
    String getUsername();

    /**
     * Get the password.
     * 
     * @return
     */
    String getHashedPassword();

    /**
     * Get the common name.
     * 
     * @return
     */
    String getFirstName();

    /**
     * Get the surname.
     * 
     * @return
     */
    String getLastName();

    /**
     * Get the last login date.
     * 
     * @return
     */
    Date getLastLogin();

    /**
     * Get the account status.
     * 
     * @return
     */
    AccountStatus getStatus();

    /**
     * Get the list of granted authorities.
     * 
     * @return
     */
    List<String> getAuthorities();
}