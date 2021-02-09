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
package com.sitewhere.spi.device.charting;

import java.io.Serializable;
import java.util.List;

/**
 * Specifies a series of chart entries that may be rendered.
 * 
 * @param <T>
 */
public interface IChartSeries<T> extends Serializable {

    /**
     * Get id a measurement represented by the series.
     * 
     * @return
     */
    String getMeasurementId();

    /**
     * Get data entries for the series.
     * 
     * @return
     */
    List<? extends IChartEntry<T>> getEntries();
}