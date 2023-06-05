		package com.mes.jss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
@Controller
public class JapsswaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JapsswaApplication.class, args);
	}

}