package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class HelloController {

	@GetMapping("/")
	public @ResponseBody ResponseEntity<String> getGreeting() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
}
