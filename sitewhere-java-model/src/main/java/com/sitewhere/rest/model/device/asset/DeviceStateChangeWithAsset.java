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

import com.sitewhere.rest.model.device.event.DeviceStateChange;
import com.sitewhere.spi.device.asset.IDeviceEventWithAsset;

/**
 * Model object for device state change with asset.
 */
public class DeviceStateChangeWithAsset extends DeviceStateChange implements IDeviceEventWithAsset {

    /** Serialization version identifier */
    private static final long serialVersionUID = -7240669600220337960L;

    /** Name of the asset */
    private String assetName;

    /*
     * @see
     * com.sitewhere.rest.model.device.asset.DeviceAlertWithAsset.getAssetName()#
     * getAssetName()
     */
    @Override
    public String getAssetName() {
	return assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }
}
