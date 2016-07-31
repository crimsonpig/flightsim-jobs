package com.crimsonpig.fs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:batch.properties", ignoreResourceNotFound=true),
	@PropertySource(value="file:./batch.preferences", ignoreResourceNotFound=true)
})
public class PropertiesConfig {

	@Autowired
	private Environment environment;

	public String getProperty(String key) {
		return environment.getProperty(key);
	}

	
}
