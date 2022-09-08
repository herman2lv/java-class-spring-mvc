package com.hrm.springmvcdemo.controller;

import com.hrm.springmvcdemo.service.exception.ApplicationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ControllerAdvice
@RequestMapping("/error")
public class ErrorController {

    @GetMapping
    public String error() {
        return "error";
    }

    @ExceptionHandler
    public String applicationError(ApplicationException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}

