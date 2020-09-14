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
 * Enumerates authorities used to control access to SiteWhere data.
 */
public enum SiteWhereAuthority {

    /** Group for server administration */
    Server(SiteWhereRoles.GRP_SERVER, "Server administration", null, true),

    /** View global server information */
    ViewServerInfo(SiteWhereRoles.AUTH_VIEW_SERVER_INFO, "View global server information", SiteWhereRoles.GRP_SERVER,
	    false),

    /** Group for system access setting */
    Access(SiteWhereRoles.GRP_ACCESS, "Remote access", null, true),

    /** REST services access */
    REST(SiteWhereRoles.AUTH_REST, "REST services access", SiteWhereRoles.GRP_ACCESS, false),

    /** REST services access */
    AdminConsole(SiteWhereRoles.AUTH_ADMIN_CONSOLE, "Administrative console login", SiteWhereRoles.GRP_ACCESS, false),

    /** Group for all user authorities */
    Users(SiteWhereRoles.GRP_USERS, "Users", null, true),

    /** Administer all users */
    AdminUsers(SiteWhereRoles.AUTH_ADMINISTER_USERS, "Administer all users", SiteWhereRoles.GRP_USERS, false),

    /** Administer own user profile */
    AdminSelf(SiteWhereRoles.AUTH_ADMINISTER_USER_SELF, "Administer own user profile", SiteWhereRoles.GRP_USERS, false),

    /** Group for all tenant authorities */
    Tenants(SiteWhereRoles.GRP_TENANTS, "Tenants", null, true),

    /** Administer all users */
    AdminTenants(SiteWhereRoles.AUTH_ADMINISTER_TENANTS, "Administer all tenants", SiteWhereRoles.GRP_TENANTS, false),

    /** Administer own tenant */
    AdminOwnTenant(SiteWhereRoles.AUTH_ADMINISTER_TENANT_SELF, "Administer own tenant", SiteWhereRoles.GRP_TENANTS,
	    false),

    /** Group for all schedules */
    Schedules(SiteWhereRoles.GRP_SCHEDULES, "Schedules", null, true),

    /** Administer all schedules */
    AdminSchedules(SiteWhereRoles.AUTH_ADMINISTER_SCHEDULES, "Administer schedules", SiteWhereRoles.GRP_SCHEDULES,
	    false),

    /** Add scheduled job for batch or indivisual command invocation */
    ScheduleCommands(SiteWhereRoles.AUTH_SCHEDULE_COMMANDS, "Schedule batch or individial commands",
	    SiteWhereRoles.GRP_SCHEDULES, false);

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