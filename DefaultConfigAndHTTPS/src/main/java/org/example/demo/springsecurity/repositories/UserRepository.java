package org.example.demo.springsecurity.repositories;

import org.example.demo.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//  applying the @Repository annotation on a repository interface is unnecessary and essentially redundant
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
        SELECT u FROM  User u WHERE u.username = :username
    """)
    Optional<User> findByUsername(String username);

}
