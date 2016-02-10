package com.crimsonpig.fs.service.retrieve;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class RetrieveItemFromDataSourceService {
	
	private JdbcTemplate jdbcAccessor;
	
	public void setDataSource(DataSource dataSource){
		jdbcAccessor = new JdbcTemplate(dataSource);
	}
	
	protected JdbcTemplate getJdbcAccessor(){
		return this.jdbcAccessor;
	}
	
}
