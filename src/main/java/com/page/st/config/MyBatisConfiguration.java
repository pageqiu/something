package com.page.st.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConditionalOnClass({ EnableTransactionManagement.class})  
@AutoConfigureAfter({ DataBaseConfiguration.class })
@MapperScan(basePackages = { "com.page.st.**.mapper" })
public class MyBatisConfiguration implements EnvironmentAware {

	 private static Logger log =
	 LoggerFactory.getLogger(MyBatisConfiguration.class);
	// private static Log logger =
	// LogFactory.getLog(MybatisConfiguration.class);
	private RelaxedPropertyResolver propertyResolver;
	
	private SqlSessionFactoryBean sessionFactory = null;

	@Resource(name = "dataSource")
	private DataSource dataSource;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");

	}

	@Bean
	@ConditionalOnMissingBean
	public SqlSessionFactory getSqlSessionFactory() {
		try {
			if(sessionFactory == null) {
				synchronized(this) {
					if(sessionFactory == null) {
						sessionFactory = new SqlSessionFactoryBean();
						sessionFactory.setDataSource(dataSource);
						sessionFactory.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
						sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
								.getResources(propertyResolver.getProperty("mapperLocations")));
						sessionFactory.setConfigLocation(
								new DefaultResourceLoader().getResource(propertyResolver.getProperty("configLocation")));
					}
				}
			}

			return ((SqlSessionFactory)sessionFactory.getObject());
		} catch (Exception e) {
			// logger.warn("Could not confiure mybatis session factory");

			log.error(" =====exception===" + e.getMessage()+e);
			return null;
		}
	}

	@Bean
	@ConditionalOnMissingBean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
