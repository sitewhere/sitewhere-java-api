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
package com.sitewhere.spi.batch.kafka;

import java.util.List;

import com.sitewhere.spi.batch.IBatchOperation;

/**
 * Contains information about a batch operation which has not been processed
 * into batch elements.
 */
public interface IUnprocessedBatchOperation {

    /**
     * Batch operation information.
     * 
     * @return
     */
    IBatchOperation getBatchOperation();

    /**
     * Get list of tokens for devices to which operation will be applied.
     * 
     * @return
     */
    List<String> getDeviceTokens();
}
