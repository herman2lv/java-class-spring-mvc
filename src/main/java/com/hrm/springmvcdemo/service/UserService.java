package com.hrm.springmvcdemo.service;

import com.hrm.springmvcdemo.service.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getById(Long id);

    UserDto login(String login, String password);

    List<UserDto> getAll();

    UserDto create(UserDto user);

    UserDto edit(UserDto user);

    void delete(Long id);
}
