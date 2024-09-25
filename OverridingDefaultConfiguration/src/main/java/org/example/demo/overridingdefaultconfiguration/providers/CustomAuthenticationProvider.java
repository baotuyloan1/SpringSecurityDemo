package org.example.demo.overridingdefaultconfiguration.providers;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authentication logic here

        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if ("Bao".equals(username) && "12345".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username,password, Arrays.asList());
        }else {
            throw new AuthenticationCredentialsNotFoundException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // type of Authentication implementation here
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
