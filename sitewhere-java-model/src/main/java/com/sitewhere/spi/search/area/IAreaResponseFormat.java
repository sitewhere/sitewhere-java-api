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
package com.sitewhere.spi.search.area;

/**
 * Determines which content is returned for areas.
 */
public interface IAreaResponseFormat {

    /**
     * Indicates if included area type are to be returned.
     * 
     * @return
     */
    Boolean getIncludeAreaType();

    /**
     * Indicates if assignments are to be returned.
     * 
     * @return
     */
    Boolean getIncludeAssignments();

    /**
     * Indicates if zones are to be returned.
     * 
     * @return
     */
    Boolean getIncludeZones();
}
