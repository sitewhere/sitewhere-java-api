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
package com.sitewhere.rest.model.search.scheduling;

import com.sitewhere.spi.search.scheduling.IScheduledJobResponseFormat;

/**
 * Default implementation of {@link IScheduledJobResponseFormat}.
 */
public class ScheduledJobResponseFormat implements IScheduledJobResponseFormat {

    /** Indicates if context should be included in the response */
    private Boolean includeContext;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.rest.model.search.scheduling.ScheduledJobResponseFormat.
     * getIncludeContext()
     */
    @Override
    public Boolean getIncludeContext() {
	return includeContext;
    }

    public void setIncludeContext(Boolean includeContext) {
	this.includeContext = includeContext;
    }

}
