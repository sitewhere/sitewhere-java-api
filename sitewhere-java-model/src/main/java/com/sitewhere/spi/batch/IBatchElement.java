/**
 * Copyright © 2014-2020 The SiteWhere Authors
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
package com.sitewhere.spi.batch;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Holds information about a single element within an {@link IBatchOperation}.
 */
public interface IBatchElement extends IMetadataProvider, Serializable {

    /**
     * Get Unique id.
     * 
     * @return
     */
    UUID getId();

    /**
     * Get id for parent batch operation.
     * 
     * @return
     */
    UUID getBatchOperationId();

    /**
     * Get id for associated device.
     * 
     * @return
     */
    UUID getDeviceId();

    /**
     * Get processing status indicator.
     * 
     * @return
     */
    ElementProcessingStatus getProcessingStatus();

    /**
     * Get the date on which the element was processed.
     * 
     * @return
     */
    Date getProcessedDate();
}