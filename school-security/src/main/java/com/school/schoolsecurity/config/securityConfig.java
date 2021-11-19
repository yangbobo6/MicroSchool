package com.school.schoolsecurity.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
* created by yangbo
* 2021/11/18
* */
public class securityConfig extends WebSecurityConfigurerAdapter {



    //
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

    }
}
