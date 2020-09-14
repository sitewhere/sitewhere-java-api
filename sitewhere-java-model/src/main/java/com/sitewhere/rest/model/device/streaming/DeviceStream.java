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
package com.sitewhere.rest.model.device.streaming;

import java.util.UUID;

import com.sitewhere.rest.model.common.PersistentEntity;
import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.streaming.IDeviceStream;

/**
 * Model object for a stream of binary data received from a device.
 */
public class DeviceStream extends PersistentEntity implements IDeviceStream {

    /** Serial version UID */
    private static final long serialVersionUID = -5721420122887571143L;

    /** Parent assignment id */
    private UUID assignmentId;

    /** Alias for stream id */
    private String streamId;

    /** Stream content type */
    private String contentType;

    /*
     * @see com.sitewhere.spi.device.streaming.IDeviceStream#getAssignmentId()
     */
    @Override
    public UUID getAssignmentId() {
	return assignmentId;
    }

    public void setAssignmentId(UUID assignmentId) {
	this.assignmentId = assignmentId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.streaming.IDeviceStream#getStreamId()
     */
    @Override
    public String getStreamId() {
	return streamId;
    }

    public void setStreamId(String streamId) {
	this.streamId = streamId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.spi.device.streaming.IDeviceStream#getContentType()
     */
    @Override
    public String getContentType() {
	return contentType;
    }

    public void setContentType(String contentType) {
	this.contentType = contentType;
    }

    public static DeviceStream copy(IDeviceStream input) throws SiteWhereException {
	DeviceStream result = new DeviceStream();
	result.setId(input.getId());
	result.setAssignmentId(input.getAssignmentId());
	result.setStreamId(input.getStreamId());
	result.setContentType(input.getContentType());

	PersistentEntity.copy(input, result);
	return result;
    }
}