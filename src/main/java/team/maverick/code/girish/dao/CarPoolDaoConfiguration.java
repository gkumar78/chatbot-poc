package team.maverick.code.girish.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import team.maverick.code.girish.entity.CarPoolBooking;
import team.maverick.code.girish.entity.CarPoolBookingId;
import team.maverick.code.girish.entity.CarPoolSlot;
import team.maverick.code.girish.entity.Destination;
import team.maverick.code.girish.entity.UserDetail;

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
	public HibernateTemplate getHibernateTemplate(@Autowired SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory);
		return hibernateTemplate;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager(@Autowired SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		sessionFactory.getMetadataSources().addAnnotatedClass(UserDetail.class);
		sessionFactory.getMetadataSources().addAnnotatedClass(Destination.class);
		sessionFactory.getMetadataSources().addAnnotatedClass(CarPoolSlot.class);
		sessionFactory.getMetadataSources().addAnnotatedClass(CarPoolBooking.class);
		sessionFactory.getMetadataSources().addAnnotatedClass(CarPoolBookingId.class);

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