package org.javaboy.jdbctemlpate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class MyJDBCTemplate {

    @Bean
    public JdbcTemplate jdbcTemplate1(@Qualifier("dataSource1") DataSource dataSource1){
        return new JdbcTemplate(dataSource1);
    }

    @Bean
    public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource2){
        return new JdbcTemplate(dataSource2);
    }
}
