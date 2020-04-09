package org.javaboy.jdbctemlpate.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MyDataSource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.one")
    DataSource  dataSource1(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.two")
    DataSource  dataSource2(){
        return DruidDataSourceBuilder.create().build();
    }
}
