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