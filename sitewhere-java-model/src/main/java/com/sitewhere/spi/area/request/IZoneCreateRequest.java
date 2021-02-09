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

import com.sitewhere.spi.common.ILocation;
import com.sitewhere.spi.common.request.IPersistentEntityCreateRequest;

/**
 * Interface for arguments needed to create a zone.
 */
public interface IZoneCreateRequest extends IPersistentEntityCreateRequest {

    /**
     * Get token of parent area.
     * 
     * @return
     */
    String getAreaToken();

    /**
     * Get zone name.
     * 
     * @return
     */
    String getName();

    /**
     * Get zone boundary locations.
     * 
     * @return
     */
    List<? extends ILocation> getBounds();

    /**
     * Get border color for UI.
     * 
     * @return
     */
    String getBorderColor();

    /**
     * Get opacity for border.
     * 
     * @return
     */
    Double getBorderOpacity();

    /**
     * Get fill color for UI.
     * 
     * @return
     */
    String getFillColor();

    /**
     * Get opacity for fill.
     * 
     * @return
     */
    Double getFillOpacity();
}