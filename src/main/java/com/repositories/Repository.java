package com.repositories;

import java.util.Collection;

public interface Repository<E, ID> {
    E findById(ID id);
    Collection<E> findAll();
}
