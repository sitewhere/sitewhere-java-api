/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.streaming.request;

import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Interface for arguments needed to create a chunk of stream data for a device.
 */
public interface IDeviceStreamDataCreateRequest extends IDeviceEventCreateRequest {

    /**
     * Get id of stream data belongs to.
     * 
     * @return
     */
    String getStreamId();

    /**
     * Get sequence number for ordering chunks.
     * 
     * @return
     */
    long getSequenceNumber();

    /**
     * Get chunk data.
     * 
     * @return
     */
    byte[] getData();
}