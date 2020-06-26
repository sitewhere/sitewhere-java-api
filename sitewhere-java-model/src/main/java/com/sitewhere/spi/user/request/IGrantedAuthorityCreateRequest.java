/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user.request;

import java.io.Serializable;

/**
 * Interface for arguments needed to create a granted authority.
 */
public interface IGrantedAuthorityCreateRequest extends Serializable {

    /**
     * Get the authority name.
     * 
     * @return
     */
    String getAuthority();

    /**
     * Get the description.
     * 
     * @return
     */
    String getDescription();

    /**
     * Get parent authority.
     * 
     * @return
     */
    String getParent();

    /**
     * Indicates if the authority is a group.
     * 
     * @return
     */
    boolean isGroup();
}