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
package com.sitewhere.rest.model.tenant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.tenant.ITenant;

/**
 * Default implementation of {@link ITenant} interface used for REST services.
 */
@JsonInclude(Include.NON_NULL)
public class Tenant implements ITenant {

    /** Serial version UUID */
    private static final long serialVersionUID = -353489785570975056L;

    /** Unique id */
    private String token;

    /** Tenant name */
    private String name;

    /** Device authentication token */
    private String authenticationToken;

    /** List of user ids authorized to access tenant */
    private List<String> authorizedUserIds = new ArrayList<String>();

    /** Configuration template id */
    private String configurationTemplateId;

    /** Dataset template id */
    private String datasetTemplateId;

    /** Background color */
    private String backgroundColor;

    /** Foreground color */
    private String foregroundColor;

    /** Border color */
    private String borderColor;

    /** Icon */
    private String icon;

    /** Image URL */
    private String imageUrl;

    /** Metadata map */
    private Map<String, String> metadata;

    /** Created date */
    private Date createdDate;

    /*
     * @see com.sitewhere.spi.tenant.ITenant#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * @see com.sitewhere.spi.tenant.ITenant#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.ITenant#getAuthenticationToken()
     */
    @Override
    public String getAuthenticationToken() {
	return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
	this.authenticationToken = authenticationToken;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.ITenant#getAuthorizedUserIds()
     */
    @Override
    public List<String> getAuthorizedUserIds() {
	return authorizedUserIds;
    }

    public void setAuthorizedUserIds(List<String> authorizedUserIds) {
	this.authorizedUserIds = authorizedUserIds;
    }

    /*
     * @see com.sitewhere.spi.tenant.ITenant#getConfigurationTemplateId()
     */
    @Override
    public String getConfigurationTemplateId() {
	return configurationTemplateId;
    }

    public void setConfigurationTemplateId(String configurationTemplateId) {
	this.configurationTemplateId = configurationTemplateId;
    }

    /*
     * @see com.sitewhere.spi.tenant.ITenant#getDatasetTemplateId()
     */
    @Override
    public String getDatasetTemplateId() {
	return datasetTemplateId;
    }

    public void setDatasetTemplateId(String datasetTemplateId) {
	this.datasetTemplateId = datasetTemplateId;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getBackgroundColor()
     */
    @Override
    public String getBackgroundColor() {
	return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getForegroundColor()
     */
    @Override
    public String getForegroundColor() {
	return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
	this.foregroundColor = foregroundColor;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getBorderColor()
     */
    @Override
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /*
     * @see com.sitewhere.spi.common.IIconProvider#getIcon()
     */
    @Override
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    /*
     * @see com.sitewhere.spi.common.IImageProvider#getImageUrl()
     */
    @Override
    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    /*
     * @see com.sitewhere.spi.common.IMetadataProvider#getMetadata()
     */
    @Override
    public Map<String, String> getMetadata() {
	return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
	this.metadata = metadata;
    }

    /*
     * @see com.sitewhere.spi.tenant.ITenant#getCreatedDate()
     */
    @Override
    public Date getCreatedDate() {
	return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }
}