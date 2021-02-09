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

import java.util.List;
import java.util.Map;

import com.sitewhere.spi.batch.IBatchOperation;
import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Provides information needex to create an {@link IBatchOperation}.
 */
public interface IBatchOperationCreateRequest extends IPersistentEntityCreateRequest {

    /** Metadata property with token for batch operation that generated event */
    public static final String META_BATCH_OPERATION_TOKEN = "batch";

    /**
     * Get operation to be performed.
     * 
     * @return
     */
    String getOperationType();

    /**
     * Get operation parameters.
     * 
     * @return
     */
    Map<String, String> getParameters();

    /**
     * Get list of device tokens for operation.
     * 
     * @return
     */
    List<String> getDeviceTokens();
}