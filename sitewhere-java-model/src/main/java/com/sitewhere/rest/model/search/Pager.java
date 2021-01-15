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
package com.sitewhere.rest.model.search;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.search.ISearchCriteria;

/**
 * Encapsulates paging functionality.
 */
public class Pager<T> {

    /** Result list */
    private List<T> results = new ArrayList<T>();

    /** Search criteria */
    private ISearchCriteria criteria;

    /** Number of records left to skip */
    private long toSkip;

    /** Number of records matched */
    private long matched;

    /** Total records matched */
    private long total;

    public Pager(ISearchCriteria criteria) {
	this.criteria = criteria;
	if (criteria.getPageNumber() >= 1) {
	    this.toSkip = ((criteria.getPageNumber() - 1) * criteria.getPageSize());
	} else {
	    this.toSkip = 0;
	}
	this.total = 0;
    }

    /**
     * Process a record. Return false if no more processing is needed (page of
     * records has been found).
     * 
     * @param record
     */
    public void process(T record) {
	total++;
	if (toSkip > 0) {
	    toSkip--;
	} else if ((criteria.getPageSize() == 0) || (matched < criteria.getPageSize())) {
	    results.add(record);
	    matched++;
	}
    }

    public ISearchCriteria getSearchCriteria() {
	return criteria;
    }

    public List<T> getResults() {
	return results;
    }

    public void setResults(List<T> results) {
	this.results = results;
    }

    public long getTotal() {
	return total;
    }
}