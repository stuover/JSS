package com.mes.jss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mes.jss.sale.service.ReleaseService;

@Controller
public class ReleaseController {
	
	
	
	//출고관리화면
	@GetMapping("/release")
	public String release() {
		return "sale/Release";
	}
	
	
	
}
