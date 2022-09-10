package com.hrm.springmvcdemo.web.controller;

import com.hrm.springmvcdemo.service.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.security.auth.login.AccountNotFoundException;

@Controller
@ControllerAdvice
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String error() {
        return "error";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String applicationError(AppException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String applicationError(AccountNotFoundException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}

