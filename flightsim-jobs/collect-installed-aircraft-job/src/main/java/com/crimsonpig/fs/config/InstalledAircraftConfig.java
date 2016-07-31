package com.crimsonpig.fs.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crimsonpig.fs.domain.aircraft.InstalledAircraft;
import com.crimsonpig.fs.domain.aircraft.config.AircraftConfigFile;
import com.crimsonpig.fs.processors.InstalledAircraftProcessor;
import com.crimsonpig.fs.tasklet.TruncateTableTasklet;
import com.crimsonpig.fs.writers.ListItemWriter;

@Configuration
public class InstalledAircraftConfig {

	@Autowired
	private DataSource domainDataSource;
	
	private static final String INSERT_INSTALLED_AIRCRAFT = "INSERT INTO INSTALLEDAIRCRAFT("
			+ "TITLE, AIRCRAFT_FOLDER, AIRLINE, ATC_TYPE, ATC_MODEL, UI_MANUFACTURER, UI_TYPE, UI_VARIATION) "
			+ "VALUES(:title, :aircraftFolder, :airline, :atcType, :atcModel, :uiManufacturer, :uiType, :uiVariation)";
	
	@Bean(name="deleteInstalledAircraftTasklet")
	public Tasklet deleteInstalledAircraftTasklet(){
		TruncateTableTasklet tasklet = new TruncateTableTasklet();
		tasklet.setDataSource(domainDataSource);
		tasklet.setTable("INSTALLEDAIRCRAFT");
		return tasklet;
	}
	
	@Bean(name="installedAircraftProcessor")
	public ItemProcessor<AircraftConfigFile, List<InstalledAircraft>> installedAircraftProcessor(){
		return new InstalledAircraftProcessor();
	}
	
	@Bean(name="installedAircraftListWriter")
	public ItemWriter<List<InstalledAircraft>> installedAircraftListWriter(){
		ListItemWriter<InstalledAircraft> listWriter = new ListItemWriter<InstalledAircraft>();
		listWriter.setItemWriter(installedAircraftWriter());
		return listWriter;
	}
	
	private ItemWriter<InstalledAircraft> installedAircraftWriter(){
		JdbcBatchItemWriter<InstalledAircraft> jdbcWriter = new JdbcBatchItemWriter<InstalledAircraft>();
		jdbcWriter.setDataSource(domainDataSource);
		jdbcWriter.setAssertUpdates(true);
		jdbcWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<InstalledAircraft>());
		jdbcWriter.setSql(INSERT_INSTALLED_AIRCRAFT);
		jdbcWriter.afterPropertiesSet();
		return jdbcWriter;
	}
	
	
}
