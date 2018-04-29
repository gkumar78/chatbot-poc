package team.maverick.code.girish.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarPoolDaoConfiguration {
	
	@Bean
	public CarPoolDaoImpl CarPoolDaoImpl() {
		return new CarPoolDaoImpl();
	}
	
}