/**
 * Copyright © 2014-2021 The SiteWhere Authors
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
package com.sitewhere.rest.model.search.area;

import com.sitewhere.spi.search.area.IAreaResponseFormat;

/**
 * Default implementation of {@link IAreaResponseFormat}.
 */
public class AreaResponseFormat implements IAreaResponseFormat {

    /** Include Area Type */
    private Boolean includeAreaType;

    /** Include assignments */
    private Boolean includeAssignments;

    /** Include zones */
    private Boolean includeZones;

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeAreaType()
     */
    @Override
    public Boolean getIncludeAreaType() {
	return includeAreaType;
    }

    public void setIncludeAreaType(Boolean includeAreaType) {
	this.includeAreaType = includeAreaType;
    }

    /*
     * @see
     * com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeAssignments()
     */
    @Override
    public Boolean getIncludeAssignments() {
	return includeAssignments;
    }

    public void setIncludeAssignments(Boolean includeAssignments) {
	this.includeAssignments = includeAssignments;
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getIncludeZones()
     */
    @Override
    public Boolean getIncludeZones() {
	return includeZones;
    }

    public void setIncludeZones(Boolean includeZones) {
	this.includeZones = includeZones;
    }
}
