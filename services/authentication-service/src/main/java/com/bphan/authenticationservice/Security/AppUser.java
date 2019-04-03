package com.bphan.authenticationservice.Security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class AppUser {
    
    @Id
    @Column(name = "id")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(generator="system-uuid")
    // @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    
    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "user_role")
    private String role;

    public AppUser() {}

    public AppUser(String id, String username, String passwordHash, String userRole) {
        this.id = id;
        this.username = username;
        this.password = passwordHash;
        this.role = userRole;
    }

    public AppUser(String id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.password = passwordHash;
        this.role = "USER";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Id: " + id + " username: " + username + " password: " + password + " role: " + role;
    }
}