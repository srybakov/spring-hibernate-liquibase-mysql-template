package com.nnprivate.project.service.impl;

import com.nnprivate.project.model.domain.User;
import com.nnprivate.project.model.domain.UserRole;
import com.nnprivate.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null) {
            String message = "User with login " + email + " was not found in the database";
            throw new UsernameNotFoundException(message);
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<UserRole> userRoles = userService.getUserRoles(email);
        for (UserRole role : userRoles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), grantedAuthorities);
    }
}
