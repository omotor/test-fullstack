package com.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class PersistenceContext {

    @Bean
    public DataSource createDataSource(Environment environment) {
        HikariConfig dataSourceConfig = new HikariConfig();

        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/testomotor");
        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("zsK3aBnVqw");

        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(new String[] { "com.test.model" });

        entityManagerFactoryBean.setMappingResources(new String[] { "com.test.model.User" });

        // Properties jpaProperties = new Properties();
        //
        // jpaProperties.put("hibernate.dialect",
        // env.getRequiredProperty("hibernate.dialect"));
        // jpaProperties.put("hibernate.hbm2ddl.auto",
        // env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        // jpaProperties.put("hibernate.ejb.naming_strategy",
        // env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        // jpaProperties.put("hibernate.show_sql",
        // env.getRequiredProperty("hibernate.show_sql"));
        // jpaProperties.put("hibernate.format_sql",
        // env.getRequiredProperty("hibernate.format_sql"));
        //
        // entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

}
