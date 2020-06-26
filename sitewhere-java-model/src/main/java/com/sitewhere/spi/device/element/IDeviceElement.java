/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.device.element;

import java.io.Serializable;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Common base class for elements in the {@link IDeviceElementSchema} hierarchy.
 */
public interface IDeviceElement extends IPersistentEntity, Serializable {

    /**
     * Get human-readable name for element.
     * 
     * @return
     */
    String getName();

    /**
     * Get relative path to element from parent.
     * 
     * @return
     */
    String getPath();
}