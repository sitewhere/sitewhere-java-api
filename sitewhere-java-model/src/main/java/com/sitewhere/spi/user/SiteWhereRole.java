package com.sitewhere.spi.user;

import java.util.Arrays;
import java.util.List;

public enum SiteWhereRole {
    REST("ROLE_REST", Arrays.asList(SiteWhereAuthority.REST)),
    ADMIN_CONSOLE("ROLE_ADMIN_CONSOLE",Arrays.asList(SiteWhereAuthority.AdminConsole)),
    VIEW_SERVER_INFO("ROLE_VIEW_SERVER_INFO", Arrays.asList(SiteWhereAuthority.ViewServerInfo)),
    ADMINISTER_USERS("ROLE_ADMINISTER_USERS",Arrays.asList(SiteWhereAuthority.AdminUsers)),
    ADMINISTER_USER_SELF("ROLE_ADMINISTER_USER_SELF",Arrays.asList(SiteWhereAuthority.AdminSelf)),
    ADMINISTER_TENANTS("ROLE_ADMINISTER_TENANTS",Arrays.asList(SiteWhereAuthority.AdminTenants)),
    ADMINISTER_TENANT_SELF("ROLE_ADMINISTER_TENANT_SELF",Arrays.asList(SiteWhereAuthority.AdminOwnTenant));

    private String roleName;
    private List<SiteWhereAuthority> authorities;

    public String getRoleName() {
        return roleName;
    }

    public List<SiteWhereAuthority> getAuthorities() {
        return authorities;
    }

    SiteWhereRole(final String roleName, final List<SiteWhereAuthority> authorities) {
        this.roleName = roleName;
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
