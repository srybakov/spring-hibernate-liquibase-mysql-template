package com.nnprivate.project.service;

import com.nnprivate.project.model.domain.User;
import com.nnprivate.project.model.domain.UserRole;

import java.util.List;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
public interface UserService {

    User findByEmail(String email);

    List<UserRole> getUserRoles(String email);

    List<UserRole> getUserRoles(User user);
}
