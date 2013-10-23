package com.nnprivate.project.model.sql.dao.impl;

import com.nnprivate.project.model.sql.dao.UserDao;
import com.nnprivate.project.model.sql.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

/**
 * @author Sergey Rybakov
 */
@Repository
public class UserDaoImpl extends AbstractJpaDao<Long, User> implements UserDao {

    protected UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByEmail(String email) {
        try {
            return (User) getEntityManager().createNamedQuery("findByEmail").setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
