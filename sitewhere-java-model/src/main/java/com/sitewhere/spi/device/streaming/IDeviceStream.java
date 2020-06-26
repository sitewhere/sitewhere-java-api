/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.streaming;

import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * A data stream associated with a device assignment.
 */
public interface IDeviceStream extends IPersistentEntity {

    /**
     * Get assignment stream belongs to.
     * 
     * @return
     */
    UUID getAssignmentId();

    /**
     * Get unique identifier for stream within assignment.
     * 
     * @return
     */
    String getStreamId();

    /**
     * Get content type of stream data.
     * 
     * @return
     */
    String getContentType();
}