package team.maverick.code.girish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import team.maverick.code.girish.dao.CarPoolDaoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@Import(CarPoolDaoConfiguration.class)
public class App {
	
	private static ApplicationContext context;
	
    public static void main(String[] args) {
        context = SpringApplication.run(App.class, args);
        //displayAllBeans();
    }
    
    private static void displayAllBeans() {
    	String[] beans = context.getBeanDefinitionNames();
    	for(String bean: beans) {
    		System.out.println("Spring bean = " + bean);
    	}
    }
}