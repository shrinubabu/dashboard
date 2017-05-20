package com.tcs.iou.entities.login;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Shrinubabu
 */

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users;

    public String getRole() {
        return role;
    }

    // GETTERS and SETTERS
}
