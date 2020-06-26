/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.command;

import java.io.Serializable;
import java.util.UUID;

/**
 * Sends a chunk of device stream data to a device.
 */
public interface ISendDeviceStreamDataCommand extends ISystemCommand, Serializable {

    /**
     * Token of device to receive data.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get id of stream data belongs to.
     * 
     * @return
     */
    UUID getStreamId();

    /**
     * Get sequence number of data chunk.
     * 
     * @return
     */
    long getSequenceNumber();

    /**
     * Get data.
     * 
     * @return
     */
    byte[] getData();
}