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
package com.sitewhere.rest.model.search;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Common criteria used in searches that return a list of results. Includes
 * parameters for paging of results.
 */
public class SearchCriteria implements ISearchCriteria {

    /** Search criteria for getting all records */
    public static SearchCriteria ALL = new SearchCriteria(1, 0);

    /** Page number to view */
    private Integer pageNumber;

    /** Number of records in a page of results */
    private Integer pageSize;

    public SearchCriteria() {
	this(1, 100);
    }

    public SearchCriteria(int pageNumber, int pageSize) {
	this.pageNumber = pageNumber;
	this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
	return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
	this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
	return pageSize;
    }

    public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
    }
}