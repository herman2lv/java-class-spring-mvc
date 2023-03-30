package com.hrm.springmvcdemo.service.impl;

import com.hrm.springmvcdemo.data.UserRepository;
import com.hrm.springmvcdemo.data.entity.User;
import com.hrm.springmvcdemo.service.EncryptionService;
import com.hrm.springmvcdemo.service.UserMapper;
import com.hrm.springmvcdemo.service.UserService;
import com.hrm.springmvcdemo.service.dto.UserDto;
import com.hrm.springmvcdemo.service.exception.AppException;
import com.hrm.springmvcdemo.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final UserMapper userMapper;

    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " wasn't found"));
    }

    @Override
    public UserDto login(String login, String password) {
        String hashedPassword = encryptionService.digest(password);
        return userRepository.findAll().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(hashedPassword))
                .findFirst()
                .map(userMapper::toDto)
                .orElseThrow(() -> new AppException("Bad login! Go home"));
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserDto user) {
        String originalPassword = user.getPassword();
        String hashedPassword = encryptionService.digest(originalPassword);
        user.setPassword(hashedPassword);
        User toSave = userMapper.toEntity(user);
        User saved = userRepository.save(toSave);
        return userMapper.toDto(saved);
    }

    @Override
    public UserDto edit(UserDto user) {
        User toSave = userMapper.toEntity(user);
        User saved = userRepository.save(toSave);
        return userMapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.delete(id)) {
            throw new ResourceNotFoundException("No user with id: " + id);
        }
    }
}
