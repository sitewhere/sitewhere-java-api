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
package com.sitewhere.rest.model.search.customer;

import com.sitewhere.spi.search.customer.ICustomerTypeResponseFormat;

/**
 * Default implementation of {@link ICustomerTypeResponseFormat}.
 */
public class CustomerTypeResponseFormat implements ICustomerTypeResponseFormat {

    /** Include area detail */
    private Boolean includeContainedCustomerTypes;

    /*
     * @see com.sitewhere.spi.search.customer.ICustomerTypeResponseFormat#
     * getIncludeContainedCustomerTypes()
     */
    public Boolean getIncludeContainedCustomerTypes() {
	return includeContainedCustomerTypes;
    }

    public void setIncludeContainedCustomerTypes(Boolean includeContainedCustomerTypes) {
	this.includeContainedCustomerTypes = includeContainedCustomerTypes;
    }

}
