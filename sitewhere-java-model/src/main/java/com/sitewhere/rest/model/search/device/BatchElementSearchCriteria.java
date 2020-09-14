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
package com.sitewhere.rest.model.search.device;

import com.sitewhere.rest.model.search.SearchCriteria;
import com.sitewhere.spi.batch.ElementProcessingStatus;
import com.sitewhere.spi.search.device.IBatchElementSearchCriteria;

/**
 * Search criteria specific to searching a list of batch operation elements.
 */
public class BatchElementSearchCriteria extends SearchCriteria implements IBatchElementSearchCriteria {

    /** Element processing status */
    private ElementProcessingStatus processingStatus;

    public BatchElementSearchCriteria(int pageNumber, int pageSize) {
	super(pageNumber, pageSize);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.search.device.IBatchElementSearchCriteria#
     * getProcessingStatus()
     */
    public ElementProcessingStatus getProcessingStatus() {
	return processingStatus;
    }

    public void setProcessingStatus(ElementProcessingStatus processingStatus) {
	this.processingStatus = processingStatus;
    }
}