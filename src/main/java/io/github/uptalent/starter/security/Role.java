package io.github.uptalent.starter.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    TALENT, SPONSOR, ADMIN;
    private final String roleName = "ROLE_" + name();

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
