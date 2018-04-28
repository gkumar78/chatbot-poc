package team.maverick.code.girish;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(name = "/lookup", method = RequestMethod.POST, consumes = "application/json")
	String hello(@RequestBody QueryCarPool queryCarPoolData) {
		System.out.println(queryCarPoolData.getUserId());
		return "Hello World!";
	}
}
