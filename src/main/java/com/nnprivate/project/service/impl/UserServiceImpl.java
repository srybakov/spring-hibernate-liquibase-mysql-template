package com.nnprivate.project.service.impl;

import com.nnprivate.project.model.sql.dao.UserDao;
import com.nnprivate.project.model.sql.domain.User;
import com.nnprivate.project.model.sql.domain.UserRole;
import com.nnprivate.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional
    public List<UserRole> getUserRoles(String email) {
        User user = findByEmail(email);
        if (user != null){
            return user.getRoles();
        }
        return null;
    }

    @Override
    @Transactional
    public List<UserRole> getUserRoles(User user) {
        return getUserRoles(user.getEmail());
    }
}
