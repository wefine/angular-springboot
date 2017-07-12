package com.wefine.app.core.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ServiceWrapper<T> {

    List<T> findAll();

    T findById(Long id);

    @Transactional
    T create(T entity);

    @Transactional
    Optional<T> createIfAbsent(T entity);

    @Transactional
    T update(T entity);

    @Transactional
    void delete(Long id);
}
