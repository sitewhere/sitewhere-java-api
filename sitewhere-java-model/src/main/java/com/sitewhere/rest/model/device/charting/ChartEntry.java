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
package com.sitewhere.rest.model.device.charting;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sitewhere.spi.device.charting.IChartEntry;

/**
 * Chart entry implementation.
 */
public class ChartEntry<T> implements IChartEntry<T> {

    /** Serial version UID */
    private static final long serialVersionUID = -6397130714223000353L;

    /** Entry value */
    private T value;

    /** Date of measurement */
    private Date measurementDate;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.charting.IChartEntry#getValue()
     */
    @Override
    public T getValue() {
	return value;
    }

    public void setValue(T value) {
	this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.charting.IChartEntry#getMeasurementDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getMeasurementDate() {
	return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate) {
	this.measurementDate = measurementDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(IChartEntry<T> other) {
	return this.getMeasurementDate().compareTo(other.getMeasurementDate());
    }
}