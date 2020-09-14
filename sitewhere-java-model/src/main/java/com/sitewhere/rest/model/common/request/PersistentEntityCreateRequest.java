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
package com.sitewhere.rest.model.common.request;

import com.sitewhere.rest.model.common.MetadataProvider;
import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Base class for fields needed to create a persistent entity.
 */
public class PersistentEntityCreateRequest extends MetadataProvider implements IPersistentEntityCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = 8334896105601825091L;

    /** Token */
    private String token;

    /*
     * @see
     * com.sitewhere.spi.common.request.IPersistentEntityCreateRequest#getToken()
     */
    @Override
    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }
}
