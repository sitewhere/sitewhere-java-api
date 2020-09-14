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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SiteWhereRole {
    REST("ROLE_REST", "REST services access", Arrays.asList(SiteWhereAuthority.REST)), ADMIN_CONSOLE(
	    "ROLE_ADMIN_CONSOLE", "Administrative console login",
	    Arrays.asList(SiteWhereAuthority.AdminConsole)), VIEW_SERVER_INFO("ROLE_VIEW_SERVER_INFO",
		    "View global server information",
		    Arrays.asList(SiteWhereAuthority.ViewServerInfo)), ADMINISTER_USERS("ROLE_ADMINISTER_USERS",
			    "Administer all users", Arrays.asList(SiteWhereAuthority.AdminUsers)), ADMINISTER_USER_SELF(
				    "ROLE_ADMINISTER_USER_SELF", "Administer own user profile",
				    Arrays.asList(SiteWhereAuthority.AdminSelf)), ADMINISTER_TENANTS(
					    "ROLE_ADMINISTER_TENANTS", "Administer all tenants",
					    Arrays.asList(SiteWhereAuthority.AdminTenants)), ADMINISTER_TENANT_SELF(
						    "ROLE_ADMINISTER_TENANT_SELF", "Administer own tenant",
						    Arrays.asList(SiteWhereAuthority.AdminOwnTenant));

    private String roleName;
    private String description;
    private List<SiteWhereAuthority> authorities;

    public String getRoleName() {
	return roleName;
    }

    public String getDescription() {
	return description;
    }

    public List<String> getAuthoritiesAsStringList() {
	List<String> authorities = this.authorities.stream().map(auth -> auth.getName()).collect(Collectors.toList());
	return authorities;
    }

    public List<SiteWhereAuthority> getAuthorities() {
	return authorities;
    }

    SiteWhereRole(final String roleName, String description, final List<SiteWhereAuthority> authorities) {
	this.roleName = roleName;
	this.description = description;
	this.authorities = authorities;
    }

    public static List<SiteWhereAuthority> getAuthoritiesByRoleName(String roleName) {
	for (SiteWhereRole v : values()) {
	    if (v.getRoleName().equalsIgnoreCase(roleName)) {
		return v.getAuthorities();
	    }
	}

	throw new IllegalStateException(String.format("Unsupported role %s.", roleName));
    }
}
