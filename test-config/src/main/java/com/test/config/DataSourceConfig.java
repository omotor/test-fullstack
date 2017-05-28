package com.test.config;

import com.test.properties.DsProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by alexcosta on 27/05/17.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.test.repository")
@EntityScan(basePackages = "com.test.model")
@EnableConfigurationProperties(DsProperties.class)
public class DataSourceConfig extends HikariConfig {

    @Autowired
    private DsProperties dsProperties;

    @Bean
    public DataSource dataSource() throws SQLException {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dsProperties.getClassName());
        hikariConfig.setJdbcUrl(dsProperties.getJdbcUrl());
        hikariConfig.setUsername(dsProperties.getUser());
        hikariConfig.setPassword(dsProperties.getPass());

        hikariConfig.setMaximumPoolSize(dsProperties.getMaximumPollSize());
        hikariConfig.setMaxLifetime(dsProperties.getMaxLifeTime());
        hikariConfig.setConnectionTestQuery(dsProperties.getConnectionTest());
        hikariConfig.setPoolName(dsProperties.getPoolName());

        hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", dsProperties.getCachePrepStmts());
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", dsProperties.getPrepStmtCacheSize());
        hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", dsProperties.getPrepStmtCacheSize());
        hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", dsProperties.getUseServerPrepStmts());

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;

    }

}
