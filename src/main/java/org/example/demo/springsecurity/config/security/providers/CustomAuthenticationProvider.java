//package org.example.demo.springsecurity.config.security.providers;
//
//import org.example.demo.springsecurity.config.security.authentication.ApiKeyAuthentication;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
////@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Value("${very.very.very.secret.key}")
//    private String key;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        ApiKeyAuthentication ca = (ApiKeyAuthentication)  authentication;
//
//        String headerKey = ca.getKey();
//        if (key.equals(headerKey)){
//            ca.setAuthenticated(true)   ;
//            return ca;
//        }
//
//        throw new BadCredentialsException("No!");
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return ApiKeyAuthentication.class.equals(authentication);
//    }
//}
