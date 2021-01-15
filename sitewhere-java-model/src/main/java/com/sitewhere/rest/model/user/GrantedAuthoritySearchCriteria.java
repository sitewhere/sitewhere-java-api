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
package com.sitewhere.rest.model.user;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.user.IGrantedAuthoritySearchCriteria;

/**
 * Implementation of IGrantedAuthoritySearchCriteria.
 */
public class GrantedAuthoritySearchCriteria extends SearchCriteria implements IGrantedAuthoritySearchCriteria {

    /** Serial version UID */
    private static final long serialVersionUID = 3724218780869528660L;

    public GrantedAuthoritySearchCriteria() {
	super();
    }

    public GrantedAuthoritySearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }
}