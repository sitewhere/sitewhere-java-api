/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event.kafka;

import java.util.UUID;

/**
 * Event payload after payload is decoded and initial inbound processing has
 * been completed.
 */
public interface IPreprocessedEventPayload extends IDecodedEventPayload {

    /**
     * Get unique device id.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get unique device assignment id.
     * 
     * @return
     */
    UUID getDeviceAssignmentId();
}
