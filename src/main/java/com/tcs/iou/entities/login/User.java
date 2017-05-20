package com.tcs.iou.entities.login;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Shrinubabu
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;

    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    // GETTERS and SETTERS
}