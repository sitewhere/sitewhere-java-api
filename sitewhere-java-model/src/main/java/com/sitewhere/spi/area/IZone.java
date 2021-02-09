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
package com.sitewhere.spi.area;

import java.util.UUID;

import com.sitewhere.spi.common.IPersistentEntity;

/**
 * A polygonal area associated with a site that can be used to trigger events.
 */
public interface IZone extends IBoundedEntity, IPersistentEntity {

    /**
     * Get id for associated area.
     * 
     * @return
     */
    UUID getAreaId();

    /**
     * Get display name.
     * 
     * @return
     */
    String getName();

    /**
     * Get the border color.
     * 
     * @return
     */
    String getBorderColor();

    /**
     * Get the border opacity value.
     * 
     * @return
     */
    Double getBorderOpacity();

    /**
     * Get the fill color.
     * 
     * @return
     */
    String getFillColor();

    /**
     * Get the fill opacity value.
     * 
     * @return
     */
    Double getFillOpacity();
}