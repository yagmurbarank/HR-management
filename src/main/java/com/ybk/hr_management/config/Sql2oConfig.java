package com.ybk.hr_management.config;


import org.sql2o.Sql2o;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Sql2oConfig {

    @Bean
    public Sql2o sql2o(DataSource dataSource) {
        return new Sql2o(dataSource);
    }
}
