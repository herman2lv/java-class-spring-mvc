package com.hrm.springmvcdemo.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/users/getAll", "/users/delete", "/secured/*"}) //registration via annotations
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.printf("%nFilter [Security]: %s, method: %s%n", req.getRequestURI(), req.getMethod());
        Object user = req.getSession().getAttribute("user");
        if (user == null) {
            res.sendRedirect("/login");
            return;
        }
        chain.doFilter(req, res);
    }

}
