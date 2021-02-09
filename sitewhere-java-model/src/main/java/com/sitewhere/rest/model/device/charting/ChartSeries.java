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

import java.util.ArrayList;
import java.util.List;

import com.sitewhere.spi.device.charting.IChartSeries;

/**
 * Chart series implementation.
 */
public class ChartSeries<T> implements IChartSeries<T> {

    /** Serial version UID */
    private static final long serialVersionUID = 6247118353120214502L;

    /** Measurement id */
    private String measurementId;

    /** Entries for the chart series */
    private List<ChartEntry<T>> entries = new ArrayList<ChartEntry<T>>();

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.charting.IChartSeries#getMeasurementId()
     */
    @Override
    public String getMeasurementId() {
	return measurementId;
    }

    public void setMeasurementId(String measurementId) {
	this.measurementId = measurementId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.charting.IChartSeries#getEntries()
     */
    @Override
    public List<ChartEntry<T>> getEntries() {
	return entries;
    }

    public void setEntries(List<ChartEntry<T>> entries) {
	this.entries = entries;
    }
}