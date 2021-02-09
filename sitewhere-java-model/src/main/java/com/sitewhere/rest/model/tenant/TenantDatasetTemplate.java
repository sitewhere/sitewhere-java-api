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
package com.sitewhere.rest.model.tenant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.tenant.ITenantDatasetTemplate;

/**
 * Default implementation of {@link ITenantDatasetTemplate} interface used for
 * REST services.
 */
@JsonInclude(Include.NON_NULL)
public class TenantDatasetTemplate implements ITenantDatasetTemplate {

    /** Unique id */
    private String id;

    /** Tenant dataset Template name */
    private String name;

    /** Tenant dataset Template description */
    private String description;

    @Override
    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
