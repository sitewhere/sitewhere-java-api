/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.command;

/**
 * A parameter assocaiated with a {@link IDeviceCommand}.
 */
public interface ICommandParameter {

    /**
     * Get parameter name.
     * 
     * @return
     */
    String getName();

    /**
     * Get parameter datatype.
     * 
     * @return
     */
    ParameterType getType();

    /**
     * Indicates if parameter is required for command.
     * 
     * @return
     */
    boolean isRequired();
}