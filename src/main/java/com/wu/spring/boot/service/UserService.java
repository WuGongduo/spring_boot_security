package com.wu.spring.boot.service;


import com.wu.spring.boot.domain.User;
import com.wu.spring.boot.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByName(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
