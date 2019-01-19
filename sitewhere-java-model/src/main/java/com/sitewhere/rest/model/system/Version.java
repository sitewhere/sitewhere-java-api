/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.system;

import com.sitewhere.spi.system.IVersion;

/**
 * Model object used to read version information from REST call.
 * 
 * @author Derek
 */
public class Version implements IVersion {

    /** Serial version UID */
    private static final long serialVersionUID = -1056887925751094237L;

    /** Full edition */
    private String edition;

    /** Edition identifier */
    private String editionIdentifier;

    /** Version identifier */
    private String versionIdentifier;

    /** Build timestamp */
    private String buildTimestamp;

    /** Git revision */
    private String gitRevision;

    /** Abbreviated version of Git revision */
    private String gitRevisionAbbrev;

    public Version() {
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getEdition()
     */
    @Override
    public String getEdition() {
	return edition;
    }

    public void setEdition(String edition) {
	this.edition = edition;
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getEditionIdentifier()
     */
    @Override
    public String getEditionIdentifier() {
	return editionIdentifier;
    }

    public void setEditionIdentifier(String editionIdentifier) {
	this.editionIdentifier = editionIdentifier;
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getVersionIdentifier()
     */
    @Override
    public String getVersionIdentifier() {
	return versionIdentifier;
    }

    public void setVersionIdentifier(String versionIdentifier) {
	this.versionIdentifier = versionIdentifier;
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getBuildTimestamp()
     */
    @Override
    public String getBuildTimestamp() {
	return buildTimestamp;
    }

    public void setBuildTimestamp(String buildTimestamp) {
	this.buildTimestamp = buildTimestamp;
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getGitRevision()
     */
    @Override
    public String getGitRevision() {
	return gitRevision;
    }

    public void setGitRevision(String gitRevision) {
	this.gitRevision = gitRevision;
    }

    /*
     * @see com.sitewhere.spi.system.IVersion#getGitRevisionAbbrev()
     */
    @Override
    public String getGitRevisionAbbrev() {
	return gitRevisionAbbrev;
    }

    public void setGitRevisionAbbrev(String gitRevisionAbbrev) {
	this.gitRevisionAbbrev = gitRevisionAbbrev;
    }
}