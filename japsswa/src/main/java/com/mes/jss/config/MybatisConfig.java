package com.mes.jss.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.mes.jss.**.mapper")
public class MybatisConfig {

	
}
