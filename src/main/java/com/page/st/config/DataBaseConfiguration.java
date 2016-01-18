package com.page.st.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration  
@EnableTransactionManagement  
public class DataBaseConfiguration implements EnvironmentAware {
	
	private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class);  
	
	private RelaxedPropertyResolver propertyResolver;  

	@Override
	public void setEnvironment(Environment env) {
		this.propertyResolver = new RelaxedPropertyResolver(env,"jdbc.");  
		
	}
	
	  @Bean(name="dataSource")  
	  @Primary  
	  public BasicDataSource dataSource() {  
	        log.debug("Configruing Write DataSource");  
	          
	        BasicDataSource datasource = new BasicDataSource(); 
	        
	        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));  
	        datasource.setUsername(propertyResolver.getProperty("username"));  
	        datasource.setPassword(propertyResolver.getProperty("password"));
	        datasource.setUrl(propertyResolver.getProperty("url"));
	          
	        return datasource;  
	    } 

}
