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
package com.sitewhere.rest.model.device.marshaling;

import java.util.List;

import com.sitewhere.rest.model.area.AreaType;
import com.sitewhere.spi.area.IAreaType;

/**
 * Extends {@link AreaType} to support fields that can be included on REST
 * calls.
 */
public class MarshaledAreaType extends AreaType {

    /** Serial version UID */
    private static final long serialVersionUID = 2440287915755224663L;

    /** List of contained area types */
    private List<? extends IAreaType> containedAreaTypes;

    public List<? extends IAreaType> getContainedAreaTypes() {
	return containedAreaTypes;
    }

    public void setContainedAreaTypes(List<? extends IAreaType> containedAreaTypes) {
	this.containedAreaTypes = containedAreaTypes;
    }
}