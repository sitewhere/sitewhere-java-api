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

import com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest;

/**
 * Default implementation of {@link IGrantedAuthorityCreateRequest} for use in
 * REST services.
 */
public class GrantedAuthorityCreateRequest implements IGrantedAuthorityCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -2388892324819108444L;

    /** Authority name */
    private String authority;

    /** Description of the authority */
    private String description;

    /** Parent authority */
    private String parent;

    /** Indicates if it's a group of authorities */
    private boolean group;

    /*
     * @see
     * com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getAuthority()
     */
    @Override
    public String getAuthority() {
	return authority;
    }

    public void setAuthority(String authority) {
	this.authority = authority;
    }

    /*
     * @see
     * com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getDescription(
     * )
     */
    @Override
    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * @see
     * com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#getParent()
     */
    @Override
    public String getParent() {
	return parent;
    }

    public void setParent(String parent) {
	this.parent = parent;
    }

    /*
     * @see com.sitewhere.spi.user.request.IGrantedAuthorityCreateRequest#isGroup()
     */
    @Override
    public boolean isGroup() {
	return group;
    }

    public void setGroup(boolean group) {
	this.group = group;
    }
}
