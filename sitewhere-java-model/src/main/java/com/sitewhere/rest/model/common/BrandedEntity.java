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
package com.sitewhere.rest.model.common;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.common.IBrandedEntity;

/**
 * Base class for entities that include branding information.
 */
public abstract class BrandedEntity extends PersistentEntity implements IBrandedEntity {

    /** Serial version UID */
    private static final long serialVersionUID = 3921264232075671735L;

    /** Image URL */
    private String imageUrl;

    /** Icon */
    private String icon;

    /** Background color */
    private String backgroundColor;

    /** Foreground color */
    private String foregroundColor;

    /** Border color */
    private String borderColor;

    /*
     * @see com.sitewhere.spi.common.IImageProvider#getImageUrl()
     */
    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    /*
     * @see com.sitewhere.spi.common.IIconProvider#getIcon()
     */
    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getBackgroundColor()
     */
    public String getBackgroundColor() {
	return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
	this.backgroundColor = backgroundColor;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getForegroundColor()
     */
    public String getForegroundColor() {
	return foregroundColor;
    }

    public void setForegroundColor(String foregroundColor) {
	this.foregroundColor = foregroundColor;
    }

    /*
     * @see com.sitewhere.spi.common.IColorProvider#getBorderColor()
     */
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /**
     * Copy fields from source to target.
     * 
     * @param source
     * @param target
     */
    public static void copy(IBrandedEntity source, BrandedEntity target) throws SiteWhereException {
	target.setImageUrl(source.getImageUrl());
	target.setIcon(source.getIcon());
	target.setBackgroundColor(source.getBackgroundColor());
	target.setForegroundColor(source.getForegroundColor());
	target.setBorderColor(source.getBorderColor());
	PersistentEntity.copy(source, target);
    }
}
