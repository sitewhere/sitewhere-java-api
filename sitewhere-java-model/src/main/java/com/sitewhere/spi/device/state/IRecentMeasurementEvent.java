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
package com.sitewhere.spi.device.state;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.sitewhere.spi.device.event.IDeviceMeasurementContent;

/**
 * Annotation of a recent device measurement event.
 */
public interface IRecentMeasurementEvent extends IRecentStateEvent, IDeviceMeasurementContent, Serializable {

    /**
     * Get maximum value for measurement.
     * 
     * @return
     */
    BigDecimal getMaxValue();

    /**
     * Get date when maximum value occurred.
     * 
     * @return
     */
    Date getMaxValueDate();

    /**
     * Get minimum value for measurement.
     * 
     * @return
     */
    BigDecimal getMinValue();

    /**
     * Get date when minimum value occurred.
     * 
     * @return
     */
    Date getMinValueDate();
}
