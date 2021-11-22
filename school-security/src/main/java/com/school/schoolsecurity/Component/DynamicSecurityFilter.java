package com.school.schoolsecurity.Component;

import com.school.schoolcommon.api.IErrorCode;
import com.school.schoolsecurity.config.IgnoreUrlsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/*
*   动态权限过滤器，用于实现  基于路径的动态权限  过滤
* */
public class DynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;


    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return null;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return null;
    }
}
