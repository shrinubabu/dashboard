package com.tcs.iou.entities.login;

import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * @author Shrinubabu
 */


public class Role {

    @Id
    private long id;

    private String role;

    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
