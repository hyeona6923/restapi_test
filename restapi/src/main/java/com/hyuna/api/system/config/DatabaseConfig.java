package com.hyuna.api.system.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	  SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource);
	  PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	  sessionFactory.setMapperLocations(resolver.getResources("classpath:**/*Mapper.xml"));
	  sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
	  return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
	  SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	  return sqlSessionTemplate;
	}
}
