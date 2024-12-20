package edu.miu.ea.sandesh.ordermanagementsystem.Security;

import edu.miu.ea.sandesh.ordermanagementsystem.User.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Principal implements UserDetails {
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public Principal(String username, String password, String... authorities) {
        this.username = username;
        this.password = password;
        this.authorities = Arrays.stream(authorities).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public Principal(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.authorities = List.of(new SimpleGrantedAuthority(user.getUserRole().name()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "username='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
