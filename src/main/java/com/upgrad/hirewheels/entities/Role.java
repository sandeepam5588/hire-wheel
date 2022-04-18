package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id",length = 10, nullable = false)
    private int roleId;

    @Column(name = "role_name",length = 50, nullable = false, unique = true)
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> usersList;

    public Role(){}

    public Role(int roleId, String roleName, Set<User> usersList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.usersList = usersList;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(Set<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
