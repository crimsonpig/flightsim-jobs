package com.crimsonpig.fs.config;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchEnvironmentConfig {

	@Bean(name = "jobRepository")
	public JobRepository jobRepository() throws Exception{
		MapJobRepositoryFactoryBean jobRepository = new MapJobRepositoryFactoryBean();
		jobRepository.setTransactionManager(transactionManager());
		return jobRepository.getObject();
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(){
		return new ResourcelessTransactionManager();
	}
	
	@Bean(name = "jobLauncher")
	public JobLauncher jobLauncher() throws Exception{
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		return jobLauncher;
	}
	
}
