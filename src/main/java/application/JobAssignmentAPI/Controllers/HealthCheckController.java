package application.JobAssignmentAPI.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HealthCheckController {
	
	@GetMapping
	public String test() {
		return "Hello world";
	}

}
