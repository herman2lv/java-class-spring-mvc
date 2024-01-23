package com.hrm.springmvcdemo.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@RequiredArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "{validation.user.email.null}")//will be localized by {code}
    @Email(message = "{validation.user.email.type}")
    private String login;

    @NotBlank //Custom localized message should be used instead of default
    @Length(min = 8, message = "{validation.user.password.min}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_]).*$", message = "{validation.user.password.regexp}")
    private String password;

}
