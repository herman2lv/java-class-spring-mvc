package com.hrm.springmvcdemo.service;

import com.hrm.springmvcdemo.data.entity.User;

import java.util.List;

public interface UserService {
    User getById(Long id);

    User login(String login, String password);

    List<User> getAll();

    User create(User user);

    User edit(User user);

    void delete(Long id);
}
