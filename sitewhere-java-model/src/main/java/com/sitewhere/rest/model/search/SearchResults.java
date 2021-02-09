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

import java.util.Collections;
import java.util.List;

import com.sitewhere.spi.search.ISearchResults;

/**
 * Used to return search result metadata in response to AJAX calls.
 */
public class SearchResults<T> implements ISearchResults<T> {

    /** Number of total results */
    private long numResults;

    /** List of results */
    private List<T> results;

    public SearchResults() {
	this(Collections.emptyList());
    }

    public SearchResults(List<T> all) {
	super();
	setNumResults(all.size());
	setResults(all);
    }

    public SearchResults(List<T> page, long total) {
	setNumResults(total);
	setResults(page);
    }

    public long getNumResults() {
	return numResults;
    }

    public void setNumResults(long numResults) {
	this.numResults = numResults;
    }

    public List<T> getResults() {
	return results;
    }

    public void setResults(List<T> results) {
	this.results = results;
    }
}