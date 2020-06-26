/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.kafka;

import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Get payload passed for inbound events after they have been decoded in the
 * event sources.
 */
public interface IDecodedEventPayload {

    /**
     * Get unique event source id.
     * 
     * @return
     */
    String getSourceId();

    /**
     * Get device token.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get id of originating event.
     * 
     * @return
     */
    String getOriginator();

    /**
     * Get event create request.
     * 
     * @return
     */
    IDeviceEventCreateRequest getEventCreateRequest();
}