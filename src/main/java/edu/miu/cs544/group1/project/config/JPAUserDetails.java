package edu.miu.cs544.group1.project.config;

import edu.miu.cs544.group1.project.domain.Role;
import edu.miu.cs544.group1.project.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class JPAUserDetails implements UserDetails {
    String firstName;
    String lastName;
    String email;
    String password;
    String ssn;
    String blockchainToken;
    boolean isActive;
    Set<Role> roles;

    public JPAUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getPerson().getFirstName();
        this.lastName = user.getPerson().getLastName();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> (GrantedAuthority) role.getCode()::name).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
