package com.test.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(value="com.test.repository")
@EnableTransactionManagement
public class DataSourceConfiguration 
{
	@Autowired
	private Environment environment;
	
    @Value("${testconfig.datasource.maxPoolSize}")
    private int maxPoolSize;
 
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "testconfig.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
	
	@Bean
	public DataSource dataSource() {
		 DataSourceProperties dataSourceProperties = dataSourceProperties();
         HikariDataSource dataSource = (HikariDataSource) DataSourceBuilder
                 .create(dataSourceProperties.getClassLoader())
                 .driverClassName(dataSourceProperties.getDriverClassName())
                 .url(dataSourceProperties.getUrl())
                 .username(dataSourceProperties.getUsername())
                 .password(dataSourceProperties.getPassword())
                 .type(HikariDataSource.class)
                 .build();
         dataSource.setMaximumPoolSize(maxPoolSize);
         return dataSource;
	
	}

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("testconfig.datasource.hibernate.dialect").trim());
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("testconfig.datasource.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("testconfig.datasource.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("testconfig.datasource.hibernate.format_sql"));
        return properties;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.test.model" });
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }
	
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}
