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
package com.sitewhere.spi.common;

import java.util.Comparator;

/**
 * Commonly used comparators for SiteWhere entities.
 */
public class Comparators {

    /**
     * Lists objects with newest created first.
     */
    public static class InverseCreatedDateComparator implements Comparator<IPersistentEntity> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IPersistentEntity arg0, IPersistentEntity arg1) {
	    if ((arg0.getCreatedDate() == null) || (arg0.getCreatedDate() == null)) {
		return 0;
	    }
	    return -1 * (arg0.getCreatedDate().compareTo(arg1.getCreatedDate()));
	}
    }
}