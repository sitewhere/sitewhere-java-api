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
package com.sitewhere.rest.model.user.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.spi.user.IGrantedAuthority;
import com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest;

/**
 * Holds fields needed to create a new granted authority.
 */
@JsonInclude(Include.NON_NULL)
public class GrantedAuthorityCreateRequest implements IGrantedAuthorityCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 2752477482696017875L;

    /** Authority name */
    private String authority;

    /** Authority description */
    private String description;

    /** Parent authority */
    private String parent;

    /** Indicates whether authority is a group */
    private boolean group;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#
     * getAuthority()
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
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#
     * getDescription()
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
     * @see
     * com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getParent()
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
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#isGroup()
     */
    public boolean isGroup() {
	return group;
    }

    public void setGroup(boolean group) {
	this.group = group;
    }

    public static class Builder {

	/** Request being built */
	private GrantedAuthorityCreateRequest request = new GrantedAuthorityCreateRequest();

	public Builder(String authority) {
	    request.setAuthority(authority);
	}

	public Builder(IGrantedAuthority existing) {
	    request.setAuthority(existing.getAuthority());
	    request.setParent(existing.getParent());
	    request.setGroup(existing.isGroup());
	    request.setDescription(existing.getDescription());
	}

	public Builder withDescription(String description) {
	    request.setDescription(description);
	    return this;
	}

	public Builder withParent(String parent) {
	    request.setParent(parent);
	    return this;
	}

	public Builder makeGroup(boolean group) {
	    request.setGroup(group);
	    return this;
	}

	public GrantedAuthorityCreateRequest build() {
	    return request;
	}
    }
}