package com.wu.spring.boot.domain;

import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getName(), user.getPasswordHash(), AuthorityUtils.createAuthorityList((String[]) user.getRoleList().toArray()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public List<Role> getRole() {
        return user.getRoleList();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}
