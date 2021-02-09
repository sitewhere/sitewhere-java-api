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
package com.sitewhere.spi.scheduling;

/**
 * Metadata constants for values used by various job types.
 */
public interface JobConstants {

    /**
     * Constants used for single command invocation.
     */
    public static interface CommandInvocation {

	/** Token of assignment to target */
	public static final String ASSIGNMENT_TOKEN = "at";

	/** Token of command to invoke */
	public static final String COMMAND_TOKEN = "ct";

	/** Prefix for command parameter values */
	public static final String PARAMETER_PREFIX = "pm_";
    }

    /**
     * Constants used for batch command invocations based on device criteria.
     */
    public static interface InvocationByDeviceCriteria {

	/** Indicates if results should be narrowed by device type */
	public static final String DEVICE_TYPE_TOKEN = "dt";
    }

    /**
     * Constants used for batch command invocations based on device assignment
     * criteria.
     */
    public static interface InvocationByAssignmentCriteria {

	/** Indicates if results should be narrowed by device type */
	public static final String DEVICE_TYPE_TOKEN = "dt";

	/** Prefix for customer tokens */
	public static final String CUSTOMER_TOKEN_PREFIX = "cu_";

	/** Prefix for area tokens */
	public static final String AREA_TOKEN_PREFIX = "ar_";

	/** Prefix for asset tokens */
	public static final String ASSET_TOKEN_PREFIX = "as_";
    }
}