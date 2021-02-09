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
