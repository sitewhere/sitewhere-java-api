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
import com.sitewhere.spi.search.area.IAreaSearchCriteria;

/**
 * Model object for properties used in area searches.
 */
public class AreaSearchCriteria extends SearchCriteria implements IAreaSearchCriteria {

    /** Only return root areas */
    private Boolean rootOnly;

    /** Only return areas of the given type */
    private String areaTypeToken;

    /** Only return areas with the given parent */
    private String parentAreaToken;

    public AreaSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getRootOnly()
     */
    @Override
    public Boolean getRootOnly() {
	return rootOnly;
    }

    public void setRootOnly(Boolean rootOnly) {
	this.rootOnly = rootOnly;
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getAreaTypeToken()
     */
    @Override
    public String getAreaTypeToken() {
	return areaTypeToken;
    }

    public void setAreaTypeToken(String areaTypeToken) {
	this.areaTypeToken = areaTypeToken;
    }

    /*
     * @see com.sitewhere.spi.search.area.IAreaSearchCriteria#getParentAreaToken()
     */
    @Override
    public String getParentAreaToken() {
	return parentAreaToken;
    }

    public void setParentAreaToken(String parentAreaToken) {
	this.parentAreaToken = parentAreaToken;
    }
}
