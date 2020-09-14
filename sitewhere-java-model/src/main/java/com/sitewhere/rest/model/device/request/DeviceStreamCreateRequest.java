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
package com.sitewhere.rest.model.device.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.sitewhere.rest.model.common.request.PersistentEntityCreateRequest;
import com.sitewhere.spi.device.event.request.IDeviceStreamCreateRequest;

/**
 * Holds fields needed to create a new device stream.
 */
@JsonInclude(Include.NON_NULL)
public class DeviceStreamCreateRequest extends PersistentEntityCreateRequest implements IDeviceStreamCreateRequest {

    /** Serial version UID */
    private static final long serialVersionUID = -8887616206756385150L;

    /** Stream id */
    private String streamId;

    /** Content type */
    private String contentType;

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStreamCreateRequest#
     * getStreamId()
     */
    public String getStreamId() {
	return streamId;
    }

    public void setStreamId(String streamId) {
	this.streamId = streamId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.event.request.IDeviceStreamCreateRequest#
     * getContentType()
     */
    public String getContentType() {
	return contentType;
    }

    public void setContentType(String contentType) {
	this.contentType = contentType;
    }
}