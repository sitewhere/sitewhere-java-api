/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.system;

import java.io.Serializable;

/**
 * Interface for getting version information.
 */
public interface IVersion extends Serializable {

    /**
     * Get full edition name.
     * 
     * @return
     */
    String getEdition();

    /**
     * Get the short identifier for edition.
     * 
     * @return
     */
    String getEditionIdentifier();

    /**
     * Gets the Maven version identifier.
     * 
     * @return
     */
    String getVersionIdentifier();

    /**
     * Gets the build timestamp.
     * 
     * @return
     */
    String getBuildTimestamp();

    /**
     * Gets the Git revision id.
     * 
     * @return
     */
    String getGitRevision();

    /**
     * Gets the abbreviated version of the Git revision.
     * 
     * @return
     */
    String getGitRevisionAbbrev();
}