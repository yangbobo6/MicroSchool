package com.school.generate.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.school.generate.mbg.mapper")
public class MybatisConfig {

}
