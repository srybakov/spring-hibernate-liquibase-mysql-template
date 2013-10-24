package com.nnprivate.project.model.domain;

import java.io.Serializable;

/**
 * @author <a href="mailto:sarybako@gmail.com">Sergey Rybakov</a>
 *
 * @param <PK> - Key type
 */
public interface Identifiable<PK> extends Serializable {
    PK getId();

    boolean isNew();
}