package com.webapp.main.api.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (entityManagerFactoryRef = "bookEntityManagerFactoryRef", 
                        basePackages = {"com.webapp.main.book.repository"},transactionManagerRef = "bookTransactionManager")
public class BookDBConfig {


	@Value("${spring.book.datasource.url}")
	private String url;
	
	@Bean (name = "bookDatasource")
	public DataSource datatSource() {
		return DataSourceBuilder.create()
				.url(url)
				.username("root")
				.password("root")
				.build();
	}

	
	@Bean (name = "bookEntityManagerFactoryRef")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
	(EntityManagerFactoryBuilder builder,@Qualifier("bookDatasource") DataSource  dataSource) {
		
		Map<String, String> props=new HashMap<>();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
		return   builder
				.dataSource(dataSource)
				.packages("com.webapp.main.model.book")
				.persistenceUnit("Book")
				.properties(props)
				.build();
	}
	
	
	@Bean (name = "bookTransactionManager")
	public PlatformTransactionManager transactionManager
	(@Qualifier("bookEntityManagerFactoryRef") EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager (entityManagerFactory);
	}
}
