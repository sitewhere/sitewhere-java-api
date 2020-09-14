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
package com.sitewhere.spi;

import com.sitewhere.spi.error.ErrorCode;
import com.sitewhere.spi.error.ErrorLevel;

/**
 * System-level exception. Usually non-recoverable.
 */
public class SiteWhereSystemException extends SiteWhereException {

    /** Serial version UID */
    private static final long serialVersionUID = -7022467595218782867L;

    /** Error code */
    private ErrorCode code;

    /** Error level */
    private ErrorLevel level;

    /** HTTP response code (optional) */
    private int httpResponseCode = -1;

    public SiteWhereSystemException(ErrorCode code, ErrorLevel level) {
	this(code, null, level);
    }

    public SiteWhereSystemException(ErrorCode code, ErrorLevel level, int httpResponseCode) {
	this(code, null, level);
	setHttpResponseCode(httpResponseCode);
    }

    public SiteWhereSystemException(ErrorCode code, Throwable cause, ErrorLevel level) {
	super(code.getMessage(), cause);
	this.code = code;
	this.level = level;
    }

    /**
     * Get the error code.
     * 
     * @return
     */
    public ErrorCode getCode() {
	return code;
    }

    /**
     * Set the error code.
     * 
     * @param code
     */
    public void setCode(ErrorCode code) {
	this.code = code;
    }

    /**
     * Get the error level.
     * 
     * @return
     */
    public ErrorLevel getLevel() {
	return level;
    }

    /**
     * Set the error level.
     * 
     * @param level
     */
    public void setLevel(ErrorLevel level) {
	this.level = level;
    }

    /**
     * Get HTTP response code. (Used in REST services)
     * 
     * @return
     */
    public int getHttpResponseCode() {
	return httpResponseCode;
    }

    /**
     * Set HTTP response code. (Used in REST services)
     * 
     * @param httpResponseCode
     */
    public void setHttpResponseCode(int httpResponseCode) {
	this.httpResponseCode = httpResponseCode;
    }

    /**
     * Check whether an HTTP response code was set.
     * 
     * @return
     */
    public boolean hasHttpResponseCode() {
	return getHttpResponseCode() != -1;
    }
}