package com.nnprivate.project.service.impl;

import com.nnprivate.project.common.Constants;
import com.nnprivate.project.service.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Override
    public UserDetails getUserDetails() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return (UserDetails)authentication.getPrincipal();
    }

    @Override
    public boolean isAuthorized(){
        SecurityContext context = SecurityContextHolder.getContext();
        Collection<? extends GrantedAuthority> authorities = context.getAuthentication().getAuthorities();
        if (authorities.size() == 1 && Constants.ROLE_ANONYMOUS.equals(authorities.iterator().next().getAuthority())){
            return false;
        } else {
            return true;
        }
    }

}
