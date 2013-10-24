package com.nnprivate.project.model.dao;

import com.nnprivate.project.model.domain.User;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 */
public interface UserDao extends Dao<Long, User>{

    User findByEmail(String email);
}
