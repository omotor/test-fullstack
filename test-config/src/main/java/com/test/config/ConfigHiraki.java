package com.test.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by DEK on 24/04/2017.
 */

@Component
public class ConfigHiraki {

    @Value("${ds.url}")
    private String url;

    @Value("${ds.driver}")
    private String driver;

    @Value("${ds.username}")
    private String username;

    @Value("${ds.password}")
    private String password;

    @Bean
    private HikariDataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(100);
        ds.setDriverClassName(driver);
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

}
