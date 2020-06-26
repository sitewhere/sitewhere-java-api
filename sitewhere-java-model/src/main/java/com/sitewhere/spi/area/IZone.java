/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.area;

import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * A polygonal area associated with a site that can be used to trigger events.
 */
public interface IZone extends IBoundedEntity, IPersistentEntity {

    /**
     * Get id for associated area.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get display name.
     * 
     * @return
     */
    String getName();

    /**
     * Get the border color.
     * 
     * @return
     */
    String getBorderColor();

    /**
     * Get the border opacity value.
     * 
     * @return
     */
    Double getBorderOpacity();

    /**
     * Get the fill color.
     * 
     * @return
     */
    String getFillColor();

    /**
     * Get the fill opacity value.
     * 
     * @return
     */
    Double getFillOpacity();
}