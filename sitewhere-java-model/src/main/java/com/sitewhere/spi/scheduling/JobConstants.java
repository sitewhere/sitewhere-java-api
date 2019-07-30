/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
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