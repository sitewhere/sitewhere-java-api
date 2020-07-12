/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.device.state.request;

import java.math.BigDecimal;

import com.sitewhere.spi.device.state.request.IRecentLocationEventCreateRequest;

public class RecentLocationEventCreateRequest extends RecentStateEventCreateRequest
	implements IRecentLocationEventCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 8614328023100102695L;

    /** Latitude */
    private BigDecimal latitude;

    /** Longitude */
    private BigDecimal longitude;

    /** Elevation */
    private BigDecimal elevation;

    public BigDecimal getLatitude() {
	return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
	this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
	return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
	this.longitude = longitude;
    }

    public BigDecimal getElevation() {
	return elevation;
    }

    public void setElevation(BigDecimal elevation) {
	this.elevation = elevation;
    }
}
