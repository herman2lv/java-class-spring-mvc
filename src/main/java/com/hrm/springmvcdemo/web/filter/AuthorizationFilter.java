package com.hrm.springmvcdemo.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Example of filter registration when url patterns are specified
//see com.hrm.springmvcdemo.App class for details of filter configuration
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        Object user = req.getSession().getAttribute("user");
        if (user == null) {
            res.sendRedirect("/login");
            return;
        }
        chain.doFilter(req, res);
    }

}
