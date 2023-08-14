package in.ajay.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/contact")
	public String contact() {
		return "10 23 45 67 89";
	}
	@GetMapping("/greet")
	public String greetMsg() {
		return "Good evening all..";
	}
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to spring security app you all..";
	}
}
