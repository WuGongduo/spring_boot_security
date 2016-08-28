package com.wu.spring.boot;

import com.wu.spring.boot.domain.Customer;
import com.wu.spring.boot.domain.Role;
import com.wu.spring.boot.domain.User;
import com.wu.spring.boot.repository.CustomerRepository;
import com.wu.spring.boot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecurityApplication {
	private static final Logger log = LoggerFactory.getLogger(SecurityApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
//			repository.save(new User("wugongduo1", "111111", new Role("admin")));
//		};
//	}

}
