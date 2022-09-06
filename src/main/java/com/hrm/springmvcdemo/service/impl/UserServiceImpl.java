package com.hrm.springmvcdemo.service.impl;

import com.hrm.springmvcdemo.data.UserRepository;
import com.hrm.springmvcdemo.data.entity.User;
import com.hrm.springmvcdemo.service.UserService;
import com.hrm.springmvcdemo.service.exception.ApplicationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new ApplicationNotFoundException("User with id: " + id + " wasn't found");
        });
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.delete(id)) {
            throw new ApplicationNotFoundException("No user with id: " + id);
        }
    }
}
