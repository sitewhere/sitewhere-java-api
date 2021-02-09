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
package com.sitewhere.spi.error;

import com.sitewhere.spi.SiteWhereException;

/**
 * Indicates that a "create" operation resulted in a duplicate key.
 */
public class ResourceExistsException extends SiteWhereException {

    /** Serial version UID */
    private static final long serialVersionUID = 997625714231990638L;

    /** SiteWhere error code */
    private ErrorCode code;

    public ResourceExistsException(ErrorCode code) {
	this.code = code;
    }

    public ErrorCode getCode() {
	return code;
    }

    public void setCode(ErrorCode code) {
	this.code = code;
    }
}