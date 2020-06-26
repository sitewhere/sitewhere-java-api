/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.tenant;

import java.io.Serializable;
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
}