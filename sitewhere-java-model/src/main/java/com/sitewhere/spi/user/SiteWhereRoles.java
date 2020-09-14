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
package com.sitewhere.spi.user;

/**
 * Constants related to SiteWhere granted authorities.
 */
public interface SiteWhereRoles {

    /** Group for system access authorities */
    public static final String GRP_ACCESS = "GRP_ACCESS";

    /** Authority to access REST services */
    public static final String AUTH_REST = "REST";

    /** Authority to access administrative console */
    public static final String AUTH_ADMIN_CONSOLE = "ADMIN_CONSOLE";

    /** Group for global server administration */
    public static final String GRP_SERVER = "GRP_SERVER";

    /** Authority to view server information */
    public static final String AUTH_VIEW_SERVER_INFO = "VIEW_SERVER_INFO";

    /** Group for user authorities */
    public static final String GRP_USERS = "GRP_USERS";

    /** Authority to administer all system users */
    public static final String AUTH_ADMINISTER_USERS = "ADMINISTER_USERS";

    /** Authority to administer own user account */
    public static final String AUTH_ADMINISTER_USER_SELF = "ADMINISTER_USER_SELF";

    /** Group for tenant authorities */
    public static final String GRP_TENANTS = "GRP_TENANTS";

    /** Authority to administer all system tenants */
    public static final String AUTH_ADMINISTER_TENANTS = "ADMINISTER_TENANTS";

    /** Authority to administer own tenant */
    public static final String AUTH_ADMINISTER_TENANT_SELF = "ADMINISTER_TENANT_SELF";

    /** Group for schedule authorities */
    public static final String GRP_SCHEDULES = "GRP_SCHEDULES";

    /** Authority to administer all system schedules */
    public static final String AUTH_ADMINISTER_SCHEDULES = "ADMINISTER_SCHEDULES";

    /** Authority to schedule commands */
    public static final String AUTH_SCHEDULE_COMMANDS = "SCHEDULE_COMMANDS";

    /********************
     * ROLE DEFINITIONS *
     ********************/

    /** Prefix for Spring Security roles */
    public static final String ROLE_PREFIX = "ROLE_";

    /** Role for access to REST services */
    public static final String REST = ROLE_PREFIX + AUTH_REST;

    /** Role for access to administrative console */
    public static final String ADMIN_CONSOLE = ROLE_PREFIX + AUTH_ADMIN_CONSOLE;

    /** Role for viewing server information */
    public static final String VIEW_SERVER_INFO = ROLE_PREFIX + AUTH_VIEW_SERVER_INFO;

    /** Role to administer all system users */
    public static final String ADMINISTER_USERS = ROLE_PREFIX + AUTH_ADMINISTER_USERS;

    /** Role to administer own user account */
    public static final String ADMINISTER_USER_SELF = ROLE_PREFIX + AUTH_ADMINISTER_USER_SELF;

    /** Role to administer all system tenants */
    public static final String ADMINISTER_TENANTS = ROLE_PREFIX + AUTH_ADMINISTER_TENANTS;

    /** Role to administer all system tenants */
    public static final String ADMINISTER_TENANT_SELF = ROLE_PREFIX + AUTH_ADMINISTER_TENANT_SELF;
}