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
package com.sitewhere.rest.model.device.state.request;

import java.math.BigDecimal;

import com.sitewhere.spi.device.state.request.IRecentMeasurementEventCreateRequest;

public class RecentMeasurementEventCreateRequest extends RecentStateEventCreateRequest
	implements IRecentMeasurementEventCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -6440987741896116933L;

    /** Name */
    private String name;

    /** Value */
    private BigDecimal value;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BigDecimal getValue() {
	return value;
    }

    public void setValue(BigDecimal value) {
	this.value = value;
    }
}
