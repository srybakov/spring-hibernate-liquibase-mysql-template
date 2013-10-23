package com.nnprivate.project.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
public interface SecurityService {

    UserDetails getUserDetails();
}
