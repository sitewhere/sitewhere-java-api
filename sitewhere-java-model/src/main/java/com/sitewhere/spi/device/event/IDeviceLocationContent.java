/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.event;

import java.math.BigDecimal;

/**
 * Content associated with a device location.
 */
public interface IDeviceLocationContent {

    /**
     * Get latitude value.
     * 
     * @return
     */
    BigDecimal getLatitude();

    /**
     * Get longitude value.
     * 
     * @return
     */
    BigDecimal getLongitude();

    /**
     * Get elevation value.
     * 
     * @return
     */
    BigDecimal getElevation();
}
