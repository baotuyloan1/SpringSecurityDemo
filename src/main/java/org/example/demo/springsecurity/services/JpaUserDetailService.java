package org.example.demo.springsecurity.services;

import lombok.AllArgsConstructor;
import org.example.demo.springsecurity.repositories.UserRepository;
import org.example.demo.springsecurity.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username)  {
        var u = userRepository.findByUsername(username);
        return u.map(SecurityUser::new).orElseThrow(()-> new UsernameNotFoundException("Username not found "+username));
    }
}
