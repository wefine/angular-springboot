package com.wefine.app.core.service.impl;

import com.wefine.app.core.service.ServiceWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ServiceWrapperImpl<T> implements ServiceWrapper<T> {
    private JpaRepository<T, Long> repo;
    private Predicate<T> existedPredicate;

    public ServiceWrapperImpl(JpaRepository<T, Long> repo, Predicate<T> predicate) {
        this.repo = repo;
        this.existedPredicate = predicate;
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }

    @Override
    public T findById(Long id) {
        return repo.findOne(id);
    }

    @Override
    public T create(T entity) {
        repo.save(entity);
        return entity;
    }

    @Override
    public Optional<T> createIfAbsent(T entity) {
        Optional<T> result = Optional.empty();
        if (existedPredicate != null && !existedPredicate.test(entity)) {
            result = Optional.of(create(entity));
        }

        return result;
    }

    @Override
    public T update(T entity) {
        repo.save(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        repo.delete(id);
    }
}
