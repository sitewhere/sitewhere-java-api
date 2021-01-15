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
package com.sitewhere.spi.tenant;

import com.sitewhere.spi.SiteWhereException;

/**
 * Thrown when attempting to access a tenant that is defined in the system, but
 * is not started or is otherwise unavailable.
 */
public class TenantNotAvailableException extends SiteWhereException {

    /** Serial version UID */
    private static final long serialVersionUID = -9036156272921131169L;

    public TenantNotAvailableException() {
    }

    public TenantNotAvailableException(String message, Throwable cause) {
	super(message, cause);
    }

    public TenantNotAvailableException(String message) {
	super(message);
    }

    public TenantNotAvailableException(Throwable cause) {
	super(cause);
    }
}