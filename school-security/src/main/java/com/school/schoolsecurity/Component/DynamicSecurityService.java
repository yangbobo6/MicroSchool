package com.school.schoolsecurity.Component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/*
*   2021/11/22
*
*   动态权限相关业务
* */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
