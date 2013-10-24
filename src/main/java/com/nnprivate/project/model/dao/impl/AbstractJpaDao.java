package com.nnprivate.project.model.dao.impl;

import com.nnprivate.project.common.SortDirection;
import com.nnprivate.project.model.dao.Dao;
import com.nnprivate.project.model.domain.Identifiable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 * 
 * @param <PK>
 * @param <E>
 */
@Repository
public abstract class AbstractJpaDao<PK, E extends Identifiable<PK>> implements Dao<PK, E> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractJpaDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<E> clazz;

    protected AbstractJpaDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public E find(final PK id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public List<E> findAll() {
        return getFindAllQuery().getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.MANDATORY)
    public List<E> find(int from, int count, String sortColumn, SortDirection sortDirection) {
        Query q = getFindAllQuery(sortColumn, sortDirection);
        if (from >= 0) {
            q.setFirstResult(from);
        }
        if (count >= 0) {
            q.setMaxResults(count);
        }
        return q.getResultList();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void save(final E entity) {
        entityManager.persist(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void update(final E entity) {
        entityManager.merge(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public E merge(final E entity) {
        return entityManager.merge(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void delete(final E entity) {
        entityManager.remove(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void deleteById(PK entityId) {
        final E entity = find(entityId);
        delete(entity);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public long count() {
        return (long) entityManager.createQuery(constructCountString(null, null, null)).getSingleResult();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void saveOrUpdate(E entity) {
        if (entity.isNew()) {
            save(entity);
        } else {
            update(entity);
        }
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected Query getFindAllQuery() {
        return getFindAllQuery(null, null);
    }

    protected Query getFindAllQuery(String sortColumn, SortDirection sortDirection) {
        String query = constructQueryString(null, null, null, null, sortColumn, sortDirection);
        return entityManager.createQuery(query.toString());
    }

    protected String constructQueryString(String entityAlias, String selectClause, String joins, String conditions,
        String sortColumn, SortDirection sortDirection) {

        StringBuilder query = constructQueryString(entityAlias, selectClause, joins, conditions);

        if (StringUtils.isNotEmpty(sortColumn)) {
            query.append(" order by ").append(sortColumn);
            if (sortDirection != null) {
                query.append(" ").append(sortDirection.toString());
            }
        }
        LOG.debug("Generated query: '{}'", query.toString());
        return query.toString();
    }

    protected StringBuilder constructQueryString(String entityAlias, String selectClause, String joins,
        String conditions) {

        StringBuilder query = new StringBuilder();

        String select = "select ";

        if (StringUtils.isNotEmpty(selectClause)) {
            query.append(select).append(selectClause);
        } else if (StringUtils.isNotEmpty(entityAlias)) {
            // even if the select clause is not defined, put a default select
            // clause in case there are joins.
            // It's needed to make sure only the main entity fields are returned
            // in the result set, and not
            // all the fields of all joined entity tables - this will cause
            // class cast exception on the wicket level
            query.append(select).append(entityAlias);
        }

        query.append(" from ").append(clazz.getName());

        appendConditions(query, entityAlias, joins, conditions);

        return query;
    }

    protected String constructCountString(String entityAlias, String joins, String conditions) {

        StringBuilder query = new StringBuilder("select count(*) from ").append(clazz.getName());
        appendConditions(query, entityAlias, joins, conditions);
        return query.toString();
    }

    protected String constructQueryString() {
        return null;
    }

    private void appendConditions(StringBuilder query, String entityAlias, String joins, String conditions) {
        if (StringUtils.isNotEmpty(entityAlias)) {
            query.append(" ").append(entityAlias);
        }

        if (StringUtils.isNotEmpty(joins)) {
            query.append(" ").append(joins);
        }

        if (StringUtils.isNotEmpty(conditions)) {
            query.append(" where ").append(conditions);
        }
    }

    protected Class<E> getEntityClass() {
        return clazz;
    }

}
