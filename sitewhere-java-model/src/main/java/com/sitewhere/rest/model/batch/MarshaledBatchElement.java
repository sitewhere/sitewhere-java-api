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
package com.sitewhere.rest.model.batch;

import com.sitewhere.spi.device.IDevice;

/**
 * Extends {@link BatchElement} to support fields that can be included on REST
 * calls.
 */
public class MarshaledBatchElement extends BatchElement {

    /** Serial version UID */
    private static final long serialVersionUID = -6204681263326181682L;

    /** Referenced device */
    private IDevice device;

    public IDevice getDevice() {
	return device;
    }

    public void setDevice(IDevice device) {
	this.device = device;
    }
}