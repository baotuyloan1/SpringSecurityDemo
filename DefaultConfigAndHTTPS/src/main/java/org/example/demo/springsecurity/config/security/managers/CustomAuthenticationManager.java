//package org.example.demo.springsecurity.config.security.managers;
//
//import lombok.AllArgsConstructor;
//import org.example.demo.springsecurity.config.security.providers.CustomAuthenticationProvider;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
////@Component
//@AllArgsConstructor
//public class CustomAuthenticationManager implements AuthenticationManager {
//
//    private final CustomAuthenticationProvider customAuthenticationProvider;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if (customAuthenticationProvider.supports(authentication.getClass())){
//            return customAuthenticationProvider.authenticate(authentication);
//        }
//        throw new BadCredentialsException("Providers in this AuthenticationManager is not support!!!");
//    }
//}
