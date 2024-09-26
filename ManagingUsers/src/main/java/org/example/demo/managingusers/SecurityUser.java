package org.example.demo.managingusers;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final CustomUser customUser;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(customUser::getAuthority);
    }

    @Override
    public String getPassword() {
        return this.customUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.customUser.getUsername();
    }
}
