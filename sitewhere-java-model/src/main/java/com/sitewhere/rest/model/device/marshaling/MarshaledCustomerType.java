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
package com.sitewhere.rest.model.device.marshaling;

import java.util.List;

import com.sitewhere.rest.model.customer.CustomerType;
import com.sitewhere.spi.customer.ICustomerType;

/**
 * Extends {@link CustomerType} to support fields that can be included on REST
 * calls.
 */
public class MarshaledCustomerType extends CustomerType {

    /** Serial version UID */
    private static final long serialVersionUID = 5902204555479363292L;

    /** List of contained customer types */
    private List<? extends ICustomerType> containedCustomerTypes;

    public List<? extends ICustomerType> getContainedCustomerTypes() {
	return containedCustomerTypes;
    }

    public void setContainedCustomerTypes(List<? extends ICustomerType> containedCustomerTypes) {
	this.containedCustomerTypes = containedCustomerTypes;
    }
}
