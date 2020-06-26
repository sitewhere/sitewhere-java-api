/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.command;

import java.util.List;
import java.util.UUID;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.IPersistentEntity;

/**
 * A parameterized command issued to a device.
 */
public interface IDeviceCommand extends IPersistentEntity, IAccessible {

    /**
     * Get unique id of parent device type.
     * 
     * @return
     */
    UUID getDeviceTypeId();

    /**
     * Optional namespace for distinguishing commands.
     * 
     * @return
     */
    String getNamespace();

    /**
     * Get list of parameters.
     * 
     * @return
     */
    List<? extends ICommandParameter> getParameters();
}