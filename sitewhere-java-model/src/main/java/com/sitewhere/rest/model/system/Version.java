/**
 * Copyright © 2014-2020 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.rest.model.system;

import com.sitewhere.spi.system.IVersion;

/**
 * Model object used to read version information from REST call.
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