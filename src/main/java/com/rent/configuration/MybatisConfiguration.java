package com.rent.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.rent.mappers")
public class MybatisConfiguration {
}
