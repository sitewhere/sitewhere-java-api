/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device;

import java.math.BigDecimal;
import java.util.Map;

import com.sitewhere.spi.SiteWhereException;

/**
 * Provides simple methods for invoking commonly used SiteWhere actions.
 */
public interface IDeviceActions {

    /**
     * Create a new location for the given assignment.
     * 
     * @param assignment
     * @param latitude
     * @param longitude
     * @param elevation
     * @param updateState
     * @throws SiteWhereException
     */
    public void createLocation(IDeviceAssignment assignment, BigDecimal latitude, BigDecimal longitude,
	    BigDecimal elevation, boolean updateState) throws SiteWhereException;

    /**
     * Send command to a device.
     * 
     * @param assignment
     * @param command
     * @param parameters
     * @throws SiteWhereException
     */
    public void sendCommand(IDeviceAssignment assignment, String command, Map<String, String> parameters)
	    throws SiteWhereException;
}