package com.hrm.springmvcdemo.service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String password;

}
