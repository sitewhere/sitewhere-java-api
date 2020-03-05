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
    public String getId();

    /**
     * Get display name.
     * 
     * @return
     */
    public String getName();

    /**
     * Get description.
     * 
     * @return
     */
    public String getDescription();

    /**
     * Functional area for microservice.
     * 
     * @return
     */
    public String getFunctionalArea();

    /**
     * Get icon displayed in UI.
     * 
     * @return
     */
    public String getIcon();

    /**
     * Flag for whether microservice is multitenant.
     * 
     * @return
     */
    public boolean isMultitenant();

    /**
     * Get tag for Docker image used by microservice.
     * 
     * @return
     */
    public String getDockerImageTag();

    /**
     * Flag for whether debug is enabled.
     * 
     * @return
     */
    public boolean isDebugEnabled();

    /**
     * Port for Jdwp debugging.
     * 
     * @return
     */
    public int getDebugJdwpPort();

    /**
     * Port for JMX debugging.
     * 
     * @return
     */
    public int getDebugJmxPort();
}
