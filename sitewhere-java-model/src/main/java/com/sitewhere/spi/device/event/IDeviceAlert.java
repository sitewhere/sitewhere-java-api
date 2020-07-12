/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

import java.io.Serializable;

/**
 * Interface for an event from a device indiacating and exceptional condition.
 */
public interface IDeviceAlert extends IDeviceEvent, IDeviceAlertContent, Serializable {
}