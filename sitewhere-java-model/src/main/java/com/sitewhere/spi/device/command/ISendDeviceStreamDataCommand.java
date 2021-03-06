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
package com.sitewhere.spi.device.command;

import java.io.Serializable;
import java.util.UUID;

/**
 * Sends a chunk of device stream data to a device.
 */
public interface ISendDeviceStreamDataCommand extends ISystemCommand, Serializable {

    /**
     * Token of device to receive data.
     * 
     * @return
     */
    String getDeviceToken();

    /**
     * Get id of stream data belongs to.
     * 
     * @return
     */
    UUID getStreamId();

    /**
     * Get sequence number of data chunk.
     * 
     * @return
     */
    long getSequenceNumber();

    /**
     * Get data.
     * 
     * @return
     */
    byte[] getData();
}