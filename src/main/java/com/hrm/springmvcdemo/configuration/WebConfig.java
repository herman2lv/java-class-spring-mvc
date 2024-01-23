package com.hrm.springmvcdemo.configuration;

import com.hrm.springmvcdemo.web.filter.AuthorizationFilter;
import com.hrm.springmvcdemo.web.interceptor.MyInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final MyInterceptor myInterceptor;

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authorizationFilter() {
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter());
        registrationBean.addUrlPatterns("/users/getAll", "/users/delete", "/secured/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
