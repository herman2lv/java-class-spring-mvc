package com.hrm.springmvcdemo.data.impl;

import com.hrm.springmvcdemo.data.UserRepository;
import com.hrm.springmvcdemo.data.entity.User;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(manager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User save(User user) {
        Long id = user.getId();
        if (id == null) {
            manager.persist(user);
        } else {
            manager.merge(user);
        }
        return user;
    }

    @Override
    public boolean delete(Long id) {
        User user = manager.find(User.class, id);
        if (user == null) {
            return false;
        }
        manager.remove(user);
        return true;
    }
}
