package org.example.demo.overridingdefaultconfiguration.configs;

import org.example.demo.overridingdefaultconfiguration.providers.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// #A
@Configuration

public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    // #B
    @Bean
    UserDetailsService userDetailsService() {
        var user = User
                .withUsername("Bao")
                .password("12345")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * defining a SecurityFilterChain bean for customizing the handling of authentication and authorization
     * can directly use the SecurityFilterChain bean to set both the UserDetailsService and the PasswordEncoder
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.authorizeHttpRequests(
                c -> c.anyRequest().permitAll()
        );

        http.authenticationProvider(authenticationProvider);
        // Second way to implement UserDetailService
//        var user = User.withUsername("Bao1")
//                .password("12345")
//                .authorities("read")
//                .build();
//        var userDetailsService = new InMemoryUserDetailsManager(user);
//
//        http.userDetailsService(userDetailsService);
        return http.build();
    }
}
