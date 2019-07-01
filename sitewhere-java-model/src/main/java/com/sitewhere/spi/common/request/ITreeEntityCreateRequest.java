/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.common.request;

/**
 * Required fields for creating a tree entity.
 */
public interface ITreeEntityCreateRequest {

    /**
     * Get unique id of parent entity.
     * 
     * @return
     */
    public String getParentToken();
}
