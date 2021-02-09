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
package com.sitewhere.spi.search;

import java.util.Date;

/**
 * Extends basic search criteria with ability to search by a date range.
 */
public interface IDateRangeSearchCriteria extends ISearchCriteria {

    /**
     * Get date range start.
     * 
     * @return
     */
    Date getStartDate();

    /**
     * Get date range end.
     * 
     * @return
     */
    Date getEndDate();
}