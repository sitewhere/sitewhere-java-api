/*
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
package com.sitewhere.rest.model.area;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.BrandedEntity;
import com.sitewhere.rest.model.common.Location;
import com.sitewhere.spi.area.IArea;

/**
 * Model object for area information.
 */
@JsonInclude(Include.NON_NULL)
public class Area extends BrandedEntity implements IArea {

    /** Serialization version identifier */
    private static final long serialVersionUID = -566693689485715028L;

    /** Area type id */
    private UUID areaTypeId;

    /** Parent area id */
    private UUID parentId;

    /** Area name */
    private String name;

    /** Area description */
    private String description;

    /** Image URL */
    private String imageUrl;

    /** Area boundary coordinates */
    private List<Location> bounds = new ArrayList<Location>();

    /*
     * @see com.sitewhere.spi.area.IArea#getAreaTypeId()
     */
    @Override
    public UUID getAreaTypeId() {
	return areaTypeId;
    }

    public void setAreaTypeId(UUID areaTypeId) {
	this.areaTypeId = areaTypeId;
    }

    /*
     * @see com.sitewhere.spi.common.ITreeEntity#getParentId()
     */
    @Override
    public UUID getParentId() {
	return parentId;
    }

    public void setParentId(UUID parentId) {
	this.parentId = parentId;
    }

    /*
     * @see com.sitewhere.spi.area.IArea#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * @see com.sitewhere.spi.area.IArea#getDescription()
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see com.sitewhere.spi.area.IArea#getImageUrl()
     */
    @Override
    public String getImageUrl() {
	return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
    }

    /*
     * @see com.sitewhere.spi.area.IBoundedEntity#getBounds()
     */
    @Override
    public List<Location> getBounds() {
	return bounds;
    }

    public void setBounds(List<Location> bounds) {
	this.bounds = bounds;
    }
}