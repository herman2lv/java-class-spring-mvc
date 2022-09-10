package com.hrm.springmvcdemo.web.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, @NonNull HttpServletResponse res, @NonNull Object handler) {
        System.out.printf("Interceptor-PRE: %s, method: %s%n", req.getRequestURI(), req.getMethod());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest req, @NonNull HttpServletResponse res, @NonNull Object handler,
                           ModelAndView modelAndView) {
        System.out.printf("Interceptor-POST: %s, method: %s%n", req.getRequestURI(), req.getMethod());
    }

    @Override
    public void afterCompletion(HttpServletRequest req, @NonNull HttpServletResponse res, @NonNull Object handler,
                                Exception ex) {
        System.out.printf("Interceptor-AFTER: %s, method: %s%n", req.getRequestURI(), req.getMethod());
    }
}
