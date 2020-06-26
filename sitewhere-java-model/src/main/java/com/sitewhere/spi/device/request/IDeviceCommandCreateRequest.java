/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.request;

import java.util.List;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;
import com.sitewhere.spi.device.command.ICommandParameter;

/**
 * Interface for arguments needed to create a device command.
 */
public interface IDeviceCommandCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get token for device type command belongs to.
     * 
     * @return
     */
    String getDeviceTypeToken();

    /**
     * Optional namespace for distinguishing commands.
     * 
     * @return
     */
    String getNamespace();

    /**
     * Get command name.
     * 
     * @return
     */
    String getName();

    /**
     * Get command description.
     * 
     * @return
     */
    String getDescription();

    /**
     * Get list of parameters.
     * 
     * @return
     */
    List<ICommandParameter> getParameters();
}