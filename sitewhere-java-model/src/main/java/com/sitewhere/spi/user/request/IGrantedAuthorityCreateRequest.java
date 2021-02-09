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

import java.io.Serializable;

/**
 * Interface for arguments needed to create a granted authority.
 */
public interface IGrantedAuthorityCreateRequest extends Serializable {

    /**
     * Get the authority name.
     * 
     * @return
     */
    String getAuthority();

    /**
     * Get the description.
     * 
     * @return
     */
    String getDescription();

    /**
     * Get parent authority.
     * 
     * @return
     */
    String getParent();

    /**
     * Indicates if the authority is a group.
     * 
     * @return
     */
    boolean isGroup();
}