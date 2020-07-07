/*
 * Copyright (c) SiteWhere, LLC. All rights reserved. http://www.sitewhere.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.sitewhere.spi.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SiteWhereRole {
    REST("ROLE_REST","REST services access", Arrays.asList(SiteWhereAuthority.REST)),
    ADMIN_CONSOLE("ROLE_ADMIN_CONSOLE","Administrative console login",Arrays.asList(SiteWhereAuthority.AdminConsole)),
    VIEW_SERVER_INFO("ROLE_VIEW_SERVER_INFO","View global server information", Arrays.asList(SiteWhereAuthority.ViewServerInfo)),
    ADMINISTER_USERS("ROLE_ADMINISTER_USERS","Administer all users",Arrays.asList(SiteWhereAuthority.AdminUsers)),
    ADMINISTER_USER_SELF("ROLE_ADMINISTER_USER_SELF","Administer own user profile",Arrays.asList(SiteWhereAuthority.AdminSelf)),
    ADMINISTER_TENANTS("ROLE_ADMINISTER_TENANTS","Administer all tenants",Arrays.asList(SiteWhereAuthority.AdminTenants)),
    ADMINISTER_TENANT_SELF("ROLE_ADMINISTER_TENANT_SELF","Administer own tenant",Arrays.asList(SiteWhereAuthority.AdminOwnTenant));

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

    public static List<SiteWhereAuthority> getAuthoritiesByRoleName(String roleName){
        for(SiteWhereRole v : values()){
            if( v.getRoleName().equalsIgnoreCase(roleName)){
                return v.getAuthorities();
            }
        }

        throw new IllegalStateException(String.format("Unsupported role %s.", roleName));
    }
}
