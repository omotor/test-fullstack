package com.test.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Usuário on 26/05/2017.
 */
@Service
public abstract class GenericServiceImpl<E, K extends Serializable>
        implements GenericService<E, K> {

    private JpaRepository<E, K> jpaRepository;

    public GenericServiceImpl(JpaRepository<E,K> jpaRepository) {
        this.jpaRepository=jpaRepository;
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void saveOrUpdate(E entity) {
        jpaRepository.save(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public List<E> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public E get(K id) {
        return jpaRepository.findOne(id);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void update(E entity) {
        jpaRepository.save(entity);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void remove(E entity) {
        jpaRepository.delete(entity);
    }
}
