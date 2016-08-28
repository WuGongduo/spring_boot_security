package com.wu.spring.boot.repository;

import com.wu.spring.boot.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String lastName);
 }
