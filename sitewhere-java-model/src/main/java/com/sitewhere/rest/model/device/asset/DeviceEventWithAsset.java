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
package com.sitewhere.rest.model.device.asset;

import com.sitewhere.rest.model.device.event.DeviceEvent;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;
import com.sitewhere.spi.device.event.DeviceEventType;

/**
 * Wraps a device event and provides extra information the associated asset from
 * its assignment.
 */
public class DeviceEventWithAsset extends DeviceEvent implements IDeviceEventWithAsset {

    /** Serial version UID */
    private static final long serialVersionUID = 4865401913475898245L;

    /** asset name */
    private String assetName;

    public DeviceEventWithAsset(DeviceEventType type) {
	super(type);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.asset.IDeviceEventWithAsset#getAssetName()
     */
    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }
}