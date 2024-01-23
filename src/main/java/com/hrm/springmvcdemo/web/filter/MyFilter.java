package com.hrm.springmvcdemo.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//Example of filter registration when url patterns are not specified
@Component
@Order(1)
public class MyFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.printf("%nFilter: %s, method: %s%n", req.getRequestURI(), req.getMethod());
        chain.doFilter(req, res);
    }
}
