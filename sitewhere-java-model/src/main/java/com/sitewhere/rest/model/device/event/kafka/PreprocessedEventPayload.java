/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.event.kafka;

import com.sitewhere.spi.device.event.IDeviceEventContext;
import com.sitewhere.spi.device.event.kafka.IPreprocessedEventPayload;

/**
 * Event payload before persistence.
 */
public class PreprocessedEventPayload extends DecodedEventPayload implements IPreprocessedEventPayload {

    /** Event context */
    private IDeviceEventContext eventContext;

    /*
     * @see com.sitewhere.spi.device.event.kafka.IPreprocessedEventPayload#
     * getEventContext()
     */
    @Override
    public IDeviceEventContext getEventContext() {
	return eventContext;
    }

    public void setEventContext(IDeviceEventContext eventContext) {
	this.eventContext = eventContext;
    }
}
