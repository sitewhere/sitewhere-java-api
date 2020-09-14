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
package com.sitewhere.spi.tenant;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sitewhere.spi.common.IColorProvider;
import com.sitewhere.spi.common.IIconProvider;
import com.sitewhere.spi.common.IImageProvider;
import com.sitewhere.spi.common.IMetadataProvider;

/**
 * Interface for information about a tenant.
 */
public interface ITenant extends IColorProvider, IIconProvider, IImageProvider, IMetadataProvider, Serializable {

    /**
     * Get unique identifier.
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
     * Get id of template used to create tenant.
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

    /**
     * Get date tenant was created.
     * 
     * @return
     */
    Date getCreatedDate();
}