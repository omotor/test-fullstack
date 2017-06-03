package org.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@EnableTransactionManagement
public class DataSourceConfiguration 
{
    @Value("${testconfig.datasource.maxPoolSize}")
    private int maxPoolSize;
 
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "test.datasource")
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
}
