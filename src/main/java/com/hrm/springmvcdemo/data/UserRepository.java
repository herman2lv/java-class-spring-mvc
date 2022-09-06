package com.hrm.springmvcdemo.data;

import com.hrm.springmvcdemo.data.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    List<User> findAll();

    User save(User user);

    boolean delete(Long id);
}
