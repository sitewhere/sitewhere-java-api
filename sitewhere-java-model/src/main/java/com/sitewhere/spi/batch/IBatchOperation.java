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
package com.sitewhere.spi.batch;

import java.util.Date;
import java.util.Map;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Interface for an operation that is applied to multiple devices.
 */
public interface IBatchOperation extends IPersistentEntity {

    /**
     * Gets the type of operation to be performed.
     * 
     * @return
     */
    String getOperationType();

    /**
     * Operation parameters.
     * 
     * @return
     */
    Map<String, String> getParameters();

    /**
     * Get processing status for the batch operation.
     * 
     * @return
     */
    BatchOperationStatus getProcessingStatus();

    /**
     * Get the date when processing of the operation started.
     * 
     * @return
     */
    Date getProcessingStartedDate();

    /**
     * Get the date when processing of the operation ended.
     * 
     * @return
     */
    Date getProcessingEndedDate();
}