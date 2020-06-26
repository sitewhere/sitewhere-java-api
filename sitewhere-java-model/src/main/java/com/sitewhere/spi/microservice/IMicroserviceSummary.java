/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.microservice;

/**
 * Summarizes information about a SiteWhere microservice CRD.
 */
public interface IMicroserviceSummary {

    /**
     * Get unique id in k8s namespace.
     * 
     * @return
     */
    String getId();

    /**
     * Get display name.
     * 
     * @return
     */
    String getName();

    /**
     * Get description.
     * 
     * @return
     */
    String getDescription();

    /**
     * Functional area for microservice.
     * 
     * @return
     */
    String getFunctionalArea();

    /**
     * Get icon displayed in UI.
     * 
     * @return
     */
    String getIcon();

    /**
     * Flag for whether microservice is multitenant.
     * 
     * @return
     */
    boolean isMultitenant();

    /**
     * Get tag for Docker image used by microservice.
     * 
     * @return
     */
    String getDockerImageTag();

    /**
     * Flag for whether debug is enabled.
     * 
     * @return
     */
    boolean isDebugEnabled();

    /**
     * Port for Jdwp debugging.
     * 
     * @return
     */
    int getDebugJdwpPort();

    /**
     * Port for JMX debugging.
     * 
     * @return
     */
    int getDebugJmxPort();
}
