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
package com.sitewhere.spi.user.request;

import java.util.List;

import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Interface for arguments needed to create a user.
 */
public interface IUserCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get the username.
     *
     * @return
     */
    String getUsername();

    /**
     * Get the password.
     *
     * @return
     */
    String getPassword();

    /**
     * Get the common name.
     *
     * @return
     */
    String getFirstName();

    /**
     * Get the surname.
     *
     * @return
     */
    String getLastName();

    /**
     * Get email address.
     * 
     * @return
     */
    String getEmail();

    /**
     * Get enablement indicator.
     *
     * @return
     */
    boolean isEnabled();

    /**
     * Get the list of roles.
     *
     * @return
     */
    public List<String> getRoles();
}