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

/**
 * Status indicators for batch operation processing.
 */
public enum BatchOperationStatus {

    /** Indicates a batch operation has not been processed */
    Unprocessed,

    /** Indicates that operation is being initialized */
    Initializing,

    /** Indicates that operation has been initialized */
    InitializedSuccessfully,

    /** Indicates that some batch elements could not be created */
    InitializedWithErrors,

    /** Indicates processing succeeded for the batch operation */
    FinishedSuccessfully,

    /** Indicates processing finished with errors for the batch operation */
    FinishedWithErrors;
}