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
package com.sitewhere.rest.model.common;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Base class for persistent entities that have a unique UUID along with a
 * user-definable token. The entities also track create/update information.
 */
public class PersistentEntity extends MetadataProvider implements IPersistentEntity {

    /** Serialization version identifier */
    private static final long serialVersionUID = 1858151633970096161L;

    /** Unique device specification id */
    private UUID id;

    /** Unique token */
    private String token;

    /** Date entity was created */
    private Date createdDate;

    /** Username for creator */
    private String createdBy;

    /** Date entity was last updated */
    private Date updatedDate;

    /** Username that updated entity */
    private String updatedBy;

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getId()
     */
    @Override
    public UUID getId() {
	return id;
    }

    public void setId(UUID id) {
	this.id = id;
    }

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getCreatedDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getCreatedDate() {
	return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getCreatedBy()
     */
    @Override
    public String getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getUpdatedDate()
     */
    @Override
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date getUpdatedDate() {
	return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
    }

    /*
     * @see com.sitewhere.spi.common.IPersistentEntity#getUpdatedBy()
     */
    @Override
    public String getUpdatedBy() {
	return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
    }

    /**
     * Copy fields from source to target.
     * 
     * @param source
     * @param target
     */
    public static void copy(IPersistentEntity source, PersistentEntity target) throws SiteWhereException {
	target.setId(source.getId());
	target.setToken(source.getToken());
	target.setCreatedDate(source.getCreatedDate());
	target.setCreatedBy(source.getCreatedBy());
	target.setUpdatedDate(source.getUpdatedDate());
	target.setUpdatedBy(source.getUpdatedBy());
	MetadataProvider.copy(source, target);
    }
}