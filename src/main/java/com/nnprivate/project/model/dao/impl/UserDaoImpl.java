package com.nnprivate.project.model.dao.impl;

import com.nnprivate.project.model.dao.UserDao;
import com.nnprivate.project.model.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
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
