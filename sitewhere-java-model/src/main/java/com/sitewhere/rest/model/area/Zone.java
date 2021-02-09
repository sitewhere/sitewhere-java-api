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
package com.sitewhere.rest.model.area;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.Location;
import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.area.IZone;

/**
 * Model object for a zone.
 */
@JsonInclude(Include.NON_NULL)
public class Zone extends PersistentEntity implements IZone {

    /** Serial version UID */
    private static final long serialVersionUID = 7526239754356991844L;

    /** Id for associated area */
    private UUID areaId;

    /** Displayed name */
    private String name;

    /** Zone bounds */
    private List<Location> bounds = new ArrayList<Location>();

    /** Border color */
    private String borderColor;

    /** Border opacity */
    private Double borderOpacity;

    /** Fill color */
    private String fillColor;

    /** Fill opacity */
    private Double fillOpacity;

    /*
     * @see com.sitewhere.spi.area.IZone#getAreaId()
     */
    @Override
    public UUID getAreaId() {
	return areaId;
    }

    public void setAreaId(UUID areaId) {
	this.areaId = areaId;
    }

    /*
     * @see com.sitewhere.spi.area.IZone#getName()
     */
    @Override
    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
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

    /*
     * @see com.sitewhere.spi.area.IZone#getBorderColor()
     */
    @Override
    public String getBorderColor() {
	return borderColor;
    }

    public void setBorderColor(String borderColor) {
	this.borderColor = borderColor;
    }

    /*
     * @see com.sitewhere.spi.area.IZone#getBorderOpacity()
     */
    @Override
    public Double getBorderOpacity() {
	return borderOpacity;
    }

    public void setBorderOpacity(Double borderOpacity) {
	this.borderOpacity = borderOpacity;
    }

    /*
     * @see com.sitewhere.spi.area.IZone#getFillColor()
     */
    @Override
    public String getFillColor() {
	return fillColor;
    }

    public void setFillColor(String fillColor) {
	this.fillColor = fillColor;
    }

    /*
     * @see com.sitewhere.spi.area.IZone#getFillOpacity()
     */
    @Override
    public Double getFillOpacity() {
	return fillOpacity;
    }

    public void setFillOpacity(Double fillOpacity) {
	this.fillOpacity = fillOpacity;
    }

    /**
     * Create a copy of an SPI object. Used by web services for marshaling.
     * 
     * @param input
     * @return
     */
    public static Zone copy(IZone input) throws SiteWhereException {
	Zone result = new Zone();
	result.setId(input.getId());
	result.setToken(input.getToken());
	result.setAreaId(input.getAreaId());
	result.setName(input.getName());
	result.setCreatedDate(input.getCreatedDate());
	result.setBorderColor(input.getBorderColor());
	result.setBorderOpacity(input.getBorderOpacity());
	result.setFillColor(input.getFillColor());
	result.setFillOpacity(input.getFillOpacity());
	result.setBounds(Location.copy(input.getBounds()));

	PersistentEntity.copy(input, result);
	return result;
    }
}