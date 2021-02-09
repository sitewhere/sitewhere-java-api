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
package com.sitewhere.rest.model.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.user.IGrantedAuthority;

/**
 * Model object for a granted authority.
 */
@JsonInclude(Include.NON_NULL)
public class GrantedAuthority implements IGrantedAuthority {

    /** Serial version UID */
    private static final long serialVersionUID = 872647505610555428L;

    /** Authority */
    private String authority;

    /** Description */
    private String description;

    /** Parent authority */
    private String parent;

    /** Indicates whether authority is a group */
    private boolean group;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.IGrantedAuthority#getAuthority()
     */
    public String getAuthority() {
	return authority;
    }

    public void setAuthority(String authority) {
	this.authority = authority;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.IGrantedAuthority#getDescription()
     */
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.IGrantedAuthority#getParent()
     */
    public String getParent() {
	return parent;
    }

    public void setParent(String parent) {
	this.parent = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.IGrantedAuthority#isGroup()
     */
    public boolean isGroup() {
	return group;
    }

    public void setGroup(boolean group) {
	this.group = group;
    }

    /**
     * Copy contents from the SPI class.
     * 
     * @param input
     * @return
     */
    public static GrantedAuthority copy(IGrantedAuthority input) {
	GrantedAuthority result = new GrantedAuthority();
	result.setAuthority(input.getAuthority());
	result.setDescription(input.getDescription());
	result.setParent(input.getParent());
	result.setGroup(input.isGroup());
	return result;
    }
}