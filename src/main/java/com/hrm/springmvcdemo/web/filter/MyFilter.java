package com.hrm.springmvcdemo.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/*") //registration via annotations
public class MyFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.printf("%nFilter: %s, method: %s%n", req.getRequestURI(), req.getMethod());
        chain.doFilter(req, res);
    }
}
