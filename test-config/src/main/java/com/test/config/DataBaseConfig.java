package com.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(value="com.test.repository")
@EntityScan(value="com.test.model")
@EnableConfigurationProperties(HikariProperties.class)
@EnableAutoConfiguration
public class DataBaseConfig {

	@Autowired
	private HikariProperties hikariProperties;
	
	@Bean
	public DataSource dataSource(){
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(hikariProperties.getUrl());
		config.setUsername(hikariProperties.getUser());
		config.setPassword(hikariProperties.getPassword());
		
		config.setDriverClassName(hikariProperties.getDriverClassName());
		config.setConnectionTimeout(hikariProperties.getConnectionTimeout());
		config.setMaximumPoolSize(hikariProperties.getMaximumPoolSize());

		return new HikariDataSource(config);
	}

}
