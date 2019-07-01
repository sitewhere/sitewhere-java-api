/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.area;

import java.util.UUID;

import com.sitewhere.spi.common.IBrandedTreeEntity;

/**
 * An entity that represents a geographical area based on a previously defined
 * area type.
 */
public interface IArea extends IBrandedTreeEntity, IBoundedEntity {

    /**
     * Get id of corresponding area type.
     * 
     * @return
     */
    public UUID getAreaTypeId();
}