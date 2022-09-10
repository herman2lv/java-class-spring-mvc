package com.hrm.springmvcdemo.service.impl;

import com.hrm.springmvcdemo.data.UserRepository;
import com.hrm.springmvcdemo.data.entity.User;
import com.hrm.springmvcdemo.service.EncryptionService;
import com.hrm.springmvcdemo.service.UserService;
import com.hrm.springmvcdemo.service.exception.AppException;
import com.hrm.springmvcdemo.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EncryptionService encryptionService;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " wasn't found"));
    }

    @Override
    public User login(String login, String password) {
        String hashedPassword = encryptionService.digest(password);
        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(hashedPassword))
                .findFirst()
                .orElseThrow(() -> new AppException("Bad login! Go home"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        String originalPassword = user.getPassword();
        String hashedPassword = encryptionService.digest(originalPassword);
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.delete(id)) {
            throw new ResourceNotFoundException("No user with id: " + id);
        }
    }
}
