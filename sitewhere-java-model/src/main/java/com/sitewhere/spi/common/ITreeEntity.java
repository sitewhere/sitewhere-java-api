/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.common;

import java.util.UUID;

/**
 * Entity which can have a link to a parent entity to form a tree structure.
 */
public interface ITreeEntity extends IAccessible {

    /**
     * Get unique id of parent entity.
     * 
     * @return
     */
    public UUID getParentId();
}
