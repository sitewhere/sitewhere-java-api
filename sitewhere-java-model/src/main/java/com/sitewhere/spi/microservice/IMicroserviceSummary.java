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
