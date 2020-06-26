/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.command;

import java.io.Serializable;

/**
 * Command that indicates device registration failed.
 */
public interface IRegistrationFailureCommand extends ISystemCommand, Serializable {

    /**
     * Get reason for registration failure.
     * 
     * @return
     */
    RegistrationFailureReason getReason();

    /**
     * Get error message.
     * 
     * @return
     */
    String getErrorMessage();
}