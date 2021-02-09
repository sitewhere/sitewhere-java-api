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
package com.sitewhere.spi.area.request;

import java.util.List;

import com.sitewhere.spi.common.IAccessible;
import com.sitewhere.spi.common.ILocation;
import com.sitewhere.spi.common.request.IBrandedEntityCreateRequest;
import com.sitewhere.spi.common.request.ITreeEntityCreateRequest;

/**
 * Interface for arguments needed to create an area.
 */
public interface IAreaCreateRequest extends IAccessible, IBrandedEntityCreateRequest, ITreeEntityCreateRequest {

    /**
     * Get token for corresponding area type.
     * 
     * @return
     */
    String getAreaTypeToken();

    /**
     * Get list of coordinates that defines the area bounds.
     * 
     * @return
     */
    List<? extends ILocation> getBounds();
}