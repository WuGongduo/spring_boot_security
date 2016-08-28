package com.wu.spring.boot.domain;

import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.List;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getName(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRoles()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public List<String> getRole() {
        List<String> roles = new ArrayList<>();
        for(Role role: user.getRoleList()) {
            roles.add(role.getRoleName());
        }

        return roles;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
