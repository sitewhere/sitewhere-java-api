/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.kafka;

import com.sitewhere.spi.device.event.IDeviceEventContext;

/**
 * Event payload before persistence.
 */
public interface IPreprocessedEventPayload extends IDecodedEventPayload {

    /**
     * Get extra context information for event.
     * 
     * @return
     */
    IDeviceEventContext getEventContext();
}
