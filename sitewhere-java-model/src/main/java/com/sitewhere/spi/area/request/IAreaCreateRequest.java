/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.area.request;

import java.util.List;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.ILocation;
import com.sitewhere.spi.common.request.IBrandedEntityCreateRequest;
import com.sitewhere.spi.common.request.ITreeEntityCreateRequest;

/**
 * Interface for arguments needed to create an area.
 */
public interface IAreaCreateRequest extends IAccessible, IBrandedEntityCreateRequest, ITreeEntityCreateRequest {

    /**
     * Get token for corresponding area type.
     * 
     * @return
     */
    String getAreaTypeToken();

    /**
     * Get list of coordinates that defines the area bounds.
     * 
     * @return
     */
    List<? extends ILocation> getBounds();
}