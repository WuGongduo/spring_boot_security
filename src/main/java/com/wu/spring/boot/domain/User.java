package com.wu.spring.boot.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "userName", nullable = false, unique = true)
    private String name;
    private String passwordHash;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roleList;

    public User() {
    }

    public User(String name, String passwordHash, Role role) {
        this.name = name;
        this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
        this.roleList = Arrays.asList(role);
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    public String[] getRoles() {
        List<String> roles = new ArrayList<>();
        for(Role role : roleList) {
            roles.add(role.getRoleName());
        }
        return roles.toArray(new String[roles.size()]);
    }
}
