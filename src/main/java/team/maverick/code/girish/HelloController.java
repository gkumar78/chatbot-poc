package team.maverick.code.girish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import team.maverick.code.girish.dao.CarPoolDaoImpl;
import team.maverick.code.girish.entity.UserDetail;

//@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class); 

	@Autowired
	private CarPoolDaoImpl carPoolDaoImpl;
	
	@RequestMapping(name = "/getUser", method = RequestMethod.POST, consumes = "application/json")
	String hello(@RequestBody GetUserData getUserData) {
		System.out.println(getUserData.getUserId());
		LOGGER.info("Received /getUser call with user_id {}", getUserData.getUserId());
		
		UserDetail user = carPoolDaoImpl.getUserDetail(getUserData.getUserId());
		if(user == null) {
			return "Sorry, unable to Identify you. Please say your Id again!\n";
		} else {
			return "Welcome " + user.getFirstName() + "!\n";
		}
	}
	
	@ExceptionHandler
	private void handleException(Exception ex) {
		LOGGER.debug("Received exception : ", ex);
	}
}
