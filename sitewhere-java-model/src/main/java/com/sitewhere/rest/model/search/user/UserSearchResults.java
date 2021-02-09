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
package com.sitewhere.rest.model.search.user;

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.rest.model.search.SearchResults;
import com.sitewhere.rest.model.user.User;

/**
 * Search results that contain users. Needed so that JSON marshaling has a
 * concrete class to inflate.
 */
public class UserSearchResults extends SearchResults<User> {

    public UserSearchResults() {
	super(new ArrayList<User>());
    }

    public UserSearchResults(List<User> results) {
	super(results);
    }
}