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

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.search.area.IAreaTypeSearchCriteria;

/**
 * Model object for properties used in area types searches.
 */
public class AreaTypeSearchCriteria extends SearchCriteria implements IAreaTypeSearchCriteria {

    /** return contained area types */
    private Boolean includeContainedAreaTypes;

    public AreaTypeSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaTypeSearchCriteria#
     * getIncludeContainedAreaTypes()
     */
    @Override
    public Boolean getIncludeContainedAreaTypes() {
	return includeContainedAreaTypes;
    }

    public void setIncludeContainedAreaTypes(Boolean includeContainedAreaTypes) {
	this.includeContainedAreaTypes = includeContainedAreaTypes;
    }

}
