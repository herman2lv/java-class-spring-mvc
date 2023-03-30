package com.hrm.springmvcdemo.service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "{validation.user.email.null}")//will be localized by {code{
    @Email(message = "{validation.user.email.type}")
    private String login;

    @NotBlank //Custom localized message should be used instead of default
    @Length(min = 8, message = "{validation.user.password.min}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_]).*$", message = "{validation.user.password.regexp}")
    private String password;

}
