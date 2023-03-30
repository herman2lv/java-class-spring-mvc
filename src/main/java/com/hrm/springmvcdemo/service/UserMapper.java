package com.hrm.springmvcdemo.service;

import com.hrm.springmvcdemo.data.entity.User;
import com.hrm.springmvcdemo.service.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User entity);

    User toEntity(UserDto dto);
}
