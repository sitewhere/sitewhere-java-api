/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.request;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.device.streaming.IDeviceStream;

/**
 * Information needed to create a new {@link IDeviceStream}.
 */
public interface IDeviceStreamCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get content type of stream data.
     * 
     * @return
     */
    String getContentType();
}