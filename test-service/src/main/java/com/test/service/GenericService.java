package com.test.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Usuário on 26/05/2017.
 */
public interface GenericService<E, K extends Serializable> {
    public void saveOrUpdate(E entity);
    public List<E> getAll();
    public E get(K id);
    public void update(E entity);
    public void remove(E entity);
}
