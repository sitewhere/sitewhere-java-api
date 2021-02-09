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
package com.sitewhere.spi.user;

/**
 * Constants related to SiteWhere granted authorities.
 */
public interface SiteWhereAuthorities {

    /** Authority for all global server administration */
    public static final String ServerAdministrator = "ServerAdministrator";

    /** Authority to view server information */
    public static final String ViewServerInformation = "ViewServerInformation";

    /** Authority for all remote access authorities */
    public static final String RemoteAccessor = "RemoteAccessor";

    /** Authority to access REST services */
    public static final String RestServicesAccess = "RestServicesAccess";

    /** Authority to access administrative console */
    public static final String AdminConsoleAccess = "AdminConsoleAccess";

    /** Authority for all user management access */
    public static final String UserAdministrator = "UserAdministrator";

    /** Authority to administer all system users */
    public static final String AdminAllUsers = "AdminAllUsers";

    /** Authority to administer own user account */
    public static final String AdminUserSelf = "AdminUserSelf";

    /** Authority to administer all tenants */
    public static final String TenantAdministrator = "TenantAdministrator";

    /** Authority to administer all system tenants */
    public static final String AdminAllTenants = "AdminAllTenants";

    /** Authority to administer owned tenants */
    public static final String AdminOwnedTenants = "AdminOwnedTenants";

    /** Administrator for all schedule authorities */
    public static final String ScheduleAdministrator = "ScheduleAdministrator";

    /** Authority to administer all system schedules */
    public static final String AdminAllSchedules = "AdminAllSchedules";

    /** Authority to schedule commands */
    public static final String ScheduleCommands = "ScheduleCommands";
}