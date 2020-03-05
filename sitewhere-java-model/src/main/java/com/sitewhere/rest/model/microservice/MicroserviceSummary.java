/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.rest.model.microservice;

import com.sitewhere.spi.microservice.IMicroserviceSummary;

/**
 * Provides a subset of information stored in the SiteWhere microservice CRD.
 */
public class MicroserviceSummary implements IMicroserviceSummary {

    /** Id */
    private String id;

    /** Name */
    private String name;

    /** Description */
    private String description;

    /** Functional area */
    private String functionalArea;

    /** Icon displayed in UI */
    private String icon;

    /** Multitenant flag */
    private boolean multitenant;

    /** Tag for Docker image */
    private String dockerImageTag;

    /** Debug enabled flag */
    private boolean debugEnabled;

    /** Debug JDWP port */
    private int debugJdwpPort;

    /** Debug JMX port */
    private int debugJmxPort;

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getId()
     */
    @Override
    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getFunctionalArea()
     */
    @Override
    public String getFunctionalArea() {
	return functionalArea;
    }

    public void setFunctionalArea(String functionalArea) {
	this.functionalArea = functionalArea;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getIcon()
     */
    @Override
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#isMultitenant()
     */
    @Override
    public boolean isMultitenant() {
	return multitenant;
    }

    public void setMultitenant(boolean multitenant) {
	this.multitenant = multitenant;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getDockerImageTag()
     */
    @Override
    public String getDockerImageTag() {
	return dockerImageTag;
    }

    public void setDockerImageTag(String dockerImageTag) {
	this.dockerImageTag = dockerImageTag;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#isDebugEnabled()
     */
    @Override
    public boolean isDebugEnabled() {
	return debugEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
	this.debugEnabled = debugEnabled;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getDebugJdwpPort()
     */
    @Override
    public int getDebugJdwpPort() {
	return debugJdwpPort;
    }

    public void setDebugJdwpPort(int debugJdwpPort) {
	this.debugJdwpPort = debugJdwpPort;
    }

    /*
     * @see com.sitewhere.spi.k8s.IMicroserviceSummary#getDebugJmxPort()
     */
    @Override
    public int getDebugJmxPort() {
	return debugJmxPort;
    }

    public void setDebugJmxPort(int debugJmxPort) {
	this.debugJmxPort = debugJmxPort;
    }
}
