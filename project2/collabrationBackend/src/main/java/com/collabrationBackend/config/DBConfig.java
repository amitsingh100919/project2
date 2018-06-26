package com.collabrationBackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.collabrationBackend")
@EnableTransactionManagement
public class DBConfig {
	
	//Step 1:To set database default values
		public final String DBURL="jdbc:oracle:thin:@localhost:1521:xe";
		public final String DBDriver="oracle.jdbc.driver.OracleDriver";
		public final String DBUName="system";
		public final String DBPassword="123456";
		public final String DBDilect="org.hibernate.dialect.Oracle10gDialect";
	
	//Step 2:Create Bean for dataSource
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(DBDriver);
		dataSource.setUrl(DBURL);
		dataSource.setUsername(DBUName);
		dataSource.setPassword(DBPassword);
		
		System.out.println("----------------------------DataSource Created----------------------------------");
		
		return dataSource;
	}
	//Step 3:Create session factory bean
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(dataSource);
		lsfb.addProperties(getHibernateProperties());
		lsfb.scanPackages("com.collabrationBackend.model");
		
		System.out.println("----------------------------SessionFactory Created----------------------------------");
		
		return lsfb.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.dialect", DBDilect);
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		return hibernateProp;
	}
	
	//Step 4:TransactionManager Bean
	@Bean
	public HibernateTransactionManager getHibernateTM(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	

}
