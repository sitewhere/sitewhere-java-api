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
package com.sitewhere.spi.user;

import java.util.Date;
import java.util.List;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * Interface for accessing user information.
 */
public interface IUser extends IPersistentEntity {

    /**
     * Get the username.
     *
     * @return
     */
    String getUsername();

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
     * Email address.
     * 
     * @return
     */
    String getEmail();

    /**
     * Get the last login date.
     *
     * @return
     */
    Date getLastLogin();

    /**
     * Get the account status.
     *
     * @return
     */
    AccountStatus getStatus();

    /**
     * Get the list roles.
     *
     * @return
     */
    public List<IRole> getRoles();
}