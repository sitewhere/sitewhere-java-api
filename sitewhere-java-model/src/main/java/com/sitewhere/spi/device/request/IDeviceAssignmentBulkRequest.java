/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

import java.util.List;

/**
 * Handles requests that apply to multiple device assignments.
 */
public interface IDeviceAssignmentBulkRequest {

    /**
     * Get tokens for assignments.
     * 
     * @return
     */
    List<String> getDeviceAssignmentTokens();
}