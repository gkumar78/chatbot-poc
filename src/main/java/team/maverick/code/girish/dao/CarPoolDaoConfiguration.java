package team.maverick.code.girish.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import team.maverick.code.girish.entity.old.CarPoolBooking;
import team.maverick.code.girish.entity.old.CarPoolSlot;
import team.maverick.code.girish.entity.old.Destination;
import team.maverick.code.girish.entity.old.UserDetail;

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
	public HibernateTemplate getHibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(getSessionFactory().getObject());
		return hibernateTemplate;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(getSessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setAnnotatedClasses(UserDetail.class);
		sessionFactory.setAnnotatedClasses(Destination.class);
		sessionFactory.setAnnotatedClasses(CarPoolBooking.class);
		sessionFactory.setAnnotatedClasses(CarPoolSlot.class);
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