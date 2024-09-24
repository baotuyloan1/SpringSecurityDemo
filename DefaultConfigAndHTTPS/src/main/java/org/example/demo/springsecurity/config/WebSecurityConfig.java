package org.example.demo.springsecurity.config;

import lombok.AllArgsConstructor;
//import org.example.demo.springsecurity.config.security.filters.ApiKeyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// the name is irrelevant, you can name configuration class whatever you like
//@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

//    private final ApiKeyFilter apiKeyFilter;

    // when define this bean, spring boot don't provide us any the generated security password
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var uds = new InMemoryUserDetailsManager();
//        var u1 = User.withUsername("bao")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        uds.createUser(u1);
//
//        return uds;
//    }

    // You shouldn't create this bean in the configuration because you will need to inject the repository bean into the constructor of this @Configuration class.
    // Instead of using the @Service annotation, it will not require injecting the repository in the constructor.
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new JpaUserDetailService();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//
//        // only for development, not for production
//        return NoOpPasswordEncoder.getInstance();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager) throws Exception {
//       return httpSecurity
//               .addFilterAt(apiKeyFilter, UsernamePasswordAuthenticationFilter.class)
//               .authorizeRequests()
//               .anyRequest()
//               .authenticated()
////               .and().authenticationManager() // can set here or declare a bean of type AuthenticationManger. It will replace the default authenticationManager (override the default AuthenticationManager provided by Spring Security)
////               .and().authenticationProvider() // it doesn't override the authenticationProvider, it adds one more to the collection AuthenticationProvider
//               .and()
//               .build();
//    }


}
