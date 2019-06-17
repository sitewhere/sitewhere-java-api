/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.event.kafka;

import java.util.UUID;

import com.sitewhere.spi.device.event.kafka.IPreprocessedEventPayload;

/**
 * Payload for inbound event which has been decoded and pre-processed by inbound
 * processing.
 */
public class PreprocessedEventPayload extends DecodedEventPayload implements IPreprocessedEventPayload {

    /** Device id */
    private UUID deviceId;

    /** Device assignment id */
    private UUID deviceAssignmentId;

    /*
     * @see
     * com.sitewhere.spi.device.event.kafka.IPreprocessedEventPayload#getDeviceId()
     */
    @Override
    public UUID getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
	this.deviceId = deviceId;
    }

    /*
     * @see com.sitewhere.spi.device.event.kafka.IPreprocessedEventPayload#
     * getDeviceAssignmentId()
     */
    @Override
    public UUID getDeviceAssignmentId() {
	return deviceAssignmentId;
    }

    public void setDeviceAssignmentId(UUID deviceAssignmentId) {
	this.deviceAssignmentId = deviceAssignmentId;
    }
}
