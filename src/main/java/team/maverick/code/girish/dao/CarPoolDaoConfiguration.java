package team.maverick.code.girish.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class CarPoolDaoConfiguration {
	
	@Value("${datasource.driverClassName}")
	private String driverClassName;
	
    @Value("${datasource.url}")
    private String url;
    
    @Value("${datasource.username}")
    private String username;
    
    @Value("${datasource.password}")
    private String password;
    
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(getSessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "validate");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return props;
	}
	
	@Bean
	public CarPoolDaoImpl CarPoolDaoImpl() {
		return new CarPoolDaoImpl();
	}
	
}