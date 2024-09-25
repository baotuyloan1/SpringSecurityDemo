package org.example.demo.managingusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class ManagingUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagingUsersApplication.class, args);
    }

}
