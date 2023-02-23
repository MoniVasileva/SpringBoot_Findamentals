package com.softuni.pathfinder.domain.dto.binding;

public class RoleChangeForm {

    String roleName;

    public RoleChangeForm(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleChangeForm setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
