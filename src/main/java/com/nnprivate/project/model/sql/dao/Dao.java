package com.nnprivate.project.model.sql.dao;

import com.nnprivate.project.model.sql.domain.Identifiable;

import java.util.List;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 *
 * @param <PK>  - Key type
 * @param <E>   - Entity type
 */
public interface Dao<PK, E extends Identifiable<PK>> {

    E find(final PK id);

    List<E> findAll();

    void save(final E entity);

    void update(final E entity);

    E merge(E entity);

    void delete(final E entity);

    void deleteById(final PK entityId);

    long count();
    
    void saveOrUpdate(E entity);
}