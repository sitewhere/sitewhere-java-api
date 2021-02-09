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
package com.sitewhere.spi.device.streaming.request;

import com.sitewhere.spi.device.event.request.IDeviceEventCreateRequest;

/**
 * Interface for arguments needed to create a chunk of stream data for a device.
 */
public interface IDeviceStreamDataCreateRequest extends IDeviceEventCreateRequest {

    /**
     * Get id of stream data belongs to.
     * 
     * @return
     */
    String getStreamId();

    /**
     * Get sequence number for ordering chunks.
     * 
     * @return
     */
    long getSequenceNumber();

    /**
     * Get chunk data.
     * 
     * @return
     */
    byte[] getData();
}