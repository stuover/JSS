package com.mes.jss.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ProductProfitController {
	
	
	
	@RequestMapping("/profitManage")
	public String profitMangement() {
		
		return "production/profitManage";
	}
	
	
	
}
