/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.batch;

/**
 * Status indicators for batch operation processing.
 * 
 * @author Derek
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