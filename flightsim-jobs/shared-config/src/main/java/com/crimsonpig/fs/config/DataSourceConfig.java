package com.crimsonpig.fs.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	@Bean(name = "domainDataSource")
	public DataSource domainDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/FSTOOLS");
		dataSource.setUsername("fsmanager");
		dataSource.setPassword("fman");
		return dataSource;
	}
	
}
