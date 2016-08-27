package com.wu.spring.boot.repository;

import com.wu.spring.boot.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
 }
