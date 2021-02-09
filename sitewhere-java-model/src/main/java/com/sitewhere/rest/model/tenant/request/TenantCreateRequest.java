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
package com.sitewhere.rest.model.tenant.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.tenant.ITenant;
import com.sitewhere.spi.tenant.request.ITenantCreateRequest;

/**
 * Default implementation of {@link ITenantCreateRequest} for use in REST
 * services.
 */
@JsonInclude(Include.NON_NULL)
public class TenantCreateRequest implements ITenantCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -5706275554835627264L;

    /** Unique id */
    private String token;

    /** Tenant name */
    private String name;

    /** Device authentication token */
    private String authenticationToken;

    /** List of users authorized for access */
    private List<String> authorizedUserIds;

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

    /** Metadata */
    private Map<String, String> metadata;

    /*
     * @see com.sitewhere.spi.tenant.request.ITenantCreateRequest#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * @see com.sitewhere.spi.tenant.request.ITenantCreateRequest#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see
     * com.sitewhere.spi.tenant.request.ITenantCreateRequest#getAuthenticationToken(
     * )
     */
    @Override
    public String getAuthenticationToken() {
	return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
	this.authenticationToken = authenticationToken;
    }

    /*
     * @see
     * com.sitewhere.spi.tenant.request.ITenantCreateRequest#getAuthorizedUserIds()
     */
    @Override
    public List<String> getAuthorizedUserIds() {
	return authorizedUserIds;
    }

    public void setAuthorizedUserIds(List<String> authorizedUserIds) {
	this.authorizedUserIds = authorizedUserIds;
    }

    /*
     * @see com.sitewhere.spi.tenant.request.ITenantCreateRequest#
     * getConfigurationTemplateId()
     */
    @Override
    public String getConfigurationTemplateId() {
	return configurationTemplateId;
    }

    public void setConfigurationTemplateId(String configurationTemplateId) {
	this.configurationTemplateId = configurationTemplateId;
    }

    /*
     * @see
     * com.sitewhere.spi.tenant.request.ITenantCreateRequest#getDatasetTemplateId()
     */
    @Override
    public String getDatasetTemplateId() {
	return datasetTemplateId;
    }

    public void setDatasetTemplateId(String datasetTemplateId) {
	this.datasetTemplateId = datasetTemplateId;
    }

    /*
     * @see com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest#
     * getBackgroundColor()
     */
    @Override
    public String getBackgroundColor() {
	return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
    }

    /*
     * @see com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest#
     * getForegroundColor()
     */
    @Override
    public String getForegroundColor() {
	return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
	this.foregroundColor = foregroundColor;
    }

    /*
     * @see com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest#
     * getBorderColor()
     */
    @Override
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /*
     * @see
     * com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest#getIcon()
     */
    @Override
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    /*
     * @see com.sitewhere.rest.model.common.request.BrandedEntityCreateRequest#
     * getImageUrl()
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

    public static class Builder {

	/** Request being built */
	private TenantCreateRequest request = new TenantCreateRequest();

	public Builder(String token, String name, String authenticationToken, String logoUrl,
		String configurationTemplateId, String datasetTemplateId) {
	    request.setToken(token);
	    request.setName(name);
	    request.setAuthenticationToken(authenticationToken);
	    request.setImageUrl(logoUrl);
	    request.setConfigurationTemplateId(configurationTemplateId);
	    request.setDatasetTemplateId(datasetTemplateId);
	}

	public Builder(ITenant existing) {
	    request.setToken(existing.getToken());
	    request.setName(existing.getName());
	    request.setImageUrl(existing.getImageUrl());
	    request.setAuthenticationToken(existing.getAuthenticationToken());
	    request.setAuthorizedUserIds(existing.getAuthorizedUserIds());
	    request.setConfigurationTemplateId(existing.getConfigurationTemplateId());
	    request.setDatasetTemplateId(existing.getDatasetTemplateId());
	    request.setMetadata(existing.getMetadata());
	}

	public Builder withBackgroundColor(String color) {
	    request.setBackgroundColor(color);
	    return this;
	}

	public Builder withForegroundColor(String color) {
	    request.setForegroundColor(color);
	    return this;
	}

	public Builder withBorderColor(String color) {
	    request.setBorderColor(color);
	    return this;
	}

	public Builder withIcon(String icon) {
	    request.setIcon(icon);
	    return this;
	}

	public Builder withImageUrl(String imageUrl) {
	    request.setImageUrl(imageUrl);
	    return this;
	}

	public Builder withAuthorizedUserId(String userId) {
	    if (request.getAuthorizedUserIds() == null) {
		request.setAuthorizedUserIds(new ArrayList<String>());
	    }
	    request.getAuthorizedUserIds().add(userId);
	    return this;
	}

	public Builder metadata(String name, String value) {
	    if (request.getMetadata() == null) {
		request.setMetadata(new HashMap<String, String>());
	    }
	    request.getMetadata().put(name, value);
	    return this;
	}

	public TenantCreateRequest build() {
	    return request;
	}
    }
}