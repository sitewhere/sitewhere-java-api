/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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
