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

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Specifies criteria used to find matching areas.
 */
public interface IAreaSearchCriteria extends ISearchCriteria {

    /**
     * Indicates if only root elements are to be returned.
     * 
     * @return
     */
    Boolean getRootOnly();

    /**
     * Only match areas of the given type.
     * 
     * @return
     */
    String getAreaTypeToken();

    /**
     * Requires that areas have the given area as a parent.
     * 
     * @return
     */
    String getParentAreaToken();
}