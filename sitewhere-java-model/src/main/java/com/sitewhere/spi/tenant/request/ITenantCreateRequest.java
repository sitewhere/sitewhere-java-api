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
package com.sitewhere.spi.tenant.request;

import java.io.Serializable;
import java.util.List;

import com.sitewhere.spi.common.IColorProvider;
import com.sitewhere.spi.common.IIconProvider;
import com.sitewhere.spi.common.IImageProvider;
import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Interface for arguments needed to create a tenant.
 */
public interface ITenantCreateRequest
	extends IColorProvider, IIconProvider, IImageProvider, IMetadataProvider, Serializable {

    /**
     * Get unique id.
     * 
     * @return
     */
    String getToken();

    /**
     * Get tenant name.
     * 
     * @return
     */
    String getName();

    /**
     * Get token that devices pass to identify tenant.
     * 
     * @return
     */
    String getAuthenticationToken();

    /**
     * Get list of users authorized to access the tenant.
     * 
     * @return
     */
    List<String> getAuthorizedUserIds();

    /**
     * Get id of configuration template used for tenant.
     * 
     * @return
     */
    String getConfigurationTemplateId();

    /**
     * Get id of dataset template used to populate tenant.
     * 
     * @return
     */
    String getDatasetTemplateId();
}