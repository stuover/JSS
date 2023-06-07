package com.mes.jss.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProOutputController {
	
	

	@RequestMapping("/proOutput")
	public String proOutput(){
		return "production/processOutput";
	}
	
	
	
	
	
	
	
}
