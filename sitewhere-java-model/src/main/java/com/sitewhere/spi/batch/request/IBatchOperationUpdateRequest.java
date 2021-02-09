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
package com.sitewhere.spi.batch.request;

import java.util.Date;

import com.sitewhere.spi.batch.BatchOperationStatus;
import com.sitewhere.spi.batch.IBatchOperation;
import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Defines fields that can be updated on an {@link IBatchOperation}.
 */
public interface IBatchOperationUpdateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get updated processing status for the batch operation.
     * 
     * @return
     */
    BatchOperationStatus getProcessingStatus();

    /**
     * Get updated processing start date.
     * 
     * @return
     */
    Date getProcessingStartedDate();

    /**
     * Get updated processing end date.
     * 
     * @return
     */
    Date getProcessingEndedDate();
}