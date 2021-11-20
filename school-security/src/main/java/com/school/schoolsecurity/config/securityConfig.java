package com.school.schoolsecurity.config;


import com.school.schoolsecurity.Component.RestAuthenticationEntryPoint;
import com.school.schoolsecurity.Component.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
* created by yangbo
* 2021/11/18
* */
public class securityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    //
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    }
}
