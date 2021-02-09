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
 * Enumerates authorities used to control access to SiteWhere data.
 */
public enum SiteWhereAuthority {

    /** Authority for server administrator */
    ServerAdministrator(SiteWhereAuthorities.ServerAdministrator, "Server administration", null, true),

    /** View global server information */
    ViewServerInformation(SiteWhereAuthorities.ViewServerInformation, "View global server information",
	    SiteWhereAuthorities.ServerAdministrator, false),

    /** Authority for all remote access */
    RemoteAccessor(SiteWhereAuthorities.RemoteAccessor, "Remote accessor", null, true),

    /** REST services access */
    RestServicesAccess(SiteWhereAuthorities.RestServicesAccess, "REST services access",
	    SiteWhereAuthorities.RemoteAccessor, false),

    /** Admin UI console access */
    AdminConsoleAccess(SiteWhereAuthorities.AdminConsoleAccess, "Administrative console login",
	    SiteWhereAuthorities.RemoteAccessor, false),

    /** Group for all user authorities */
    UserAdministrator(SiteWhereAuthorities.UserAdministrator, "User administrator", null, true),

    /** Administer all users */
    AdminAllUsers(SiteWhereAuthorities.AdminAllUsers, "Administer all users", SiteWhereAuthorities.UserAdministrator,
	    false),

    /** Administer own user profile */
    AdminUserSelf(SiteWhereAuthorities.AdminUserSelf, "Administer own user profile",
	    SiteWhereAuthorities.UserAdministrator, false),

    /** Administrator with all tenant authorities */
    TenantAdministrator(SiteWhereAuthorities.TenantAdministrator, "Tenant administrator", null, true),

    /** Administer all users */
    AdminAllTenants(SiteWhereAuthorities.AdminAllTenants, "Administer all tenants",
	    SiteWhereAuthorities.TenantAdministrator, false),

    /** Administer own tenant */
    AdminOwnedTenants(SiteWhereAuthorities.AdminOwnedTenants, "Administer owned tenants",
	    SiteWhereAuthorities.TenantAdministrator, false),

    /** Administrator with all schedule authorities */
    ScheduleAdministrator(SiteWhereAuthorities.ScheduleAdministrator, "Schedule administrator", null, true),

    /** Administer all schedules */
    AdminAllSchedules(SiteWhereAuthorities.AdminAllSchedules, "Administer schedules",
	    SiteWhereAuthorities.ScheduleAdministrator, false),

    /** Add scheduled job for batch or indivisual command invocation */
    ScheduleCommands(SiteWhereAuthorities.ScheduleCommands, "Schedule batch or individial commands",
	    SiteWhereAuthorities.ScheduleAdministrator, false);

    /** Authority name */
    private String name;

    /** Authority description */
    private String description;

    /** Parent authority group */
    private String parent;

    /** Group indicator */
    private boolean group;

    private SiteWhereAuthority(String name, String description, String parent, boolean group) {
	this.name = name;
	this.description = description;
	this.parent = parent;
	this.group = group;
    }

    public String getRoleName() {
	return "ROLE_" + getName();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getParent() {
	return parent;
    }

    public void setParent(String parent) {
	this.parent = parent;
    }

    public boolean isGroup() {
	return group;
    }

    public void setGroup(boolean group) {
	this.group = group;
    }
}