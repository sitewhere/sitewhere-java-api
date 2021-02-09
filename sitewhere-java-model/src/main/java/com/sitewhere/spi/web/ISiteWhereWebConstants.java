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
package com.sitewhere.spi.web;

/**
 * Interface for constants used in web operations.
 */
public interface ISiteWhereWebConstants {

    /** Header containing JWT for authentication */
    public static final String HEADER_JWT = "X-Sitewhere-JWT";

    /** Header that holds SiteWhere tenant id being accessed */
    public static final String HEADER_TENANT_ID = "X-SiteWhere-Tenant-Id";

    /** Header that holds SiteWhere tenant auth token */
    public static final String HEADER_TENANT_AUTH = "X-SiteWhere-Tenant-Auth";

    /** Header that holds SiteWhere error string on error response */
    public static final String HEADER_SITEWHERE_ERROR = "X-SiteWhere-Error";

    /** Header that holds SiteWhere error code on error response */
    public static final String HEADER_SITEWHERE_ERROR_CODE = "X-SiteWhere-Error-Code";
}