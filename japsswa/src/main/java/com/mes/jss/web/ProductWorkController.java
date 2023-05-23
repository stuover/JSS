package com.mes.jss.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mes.jss.production.service.PlanService;
import com.mes.jss.production.service.impl.PlanServiceImpl;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class ProductWorkController {
	


	@RequestMapping("/workManage")
	public String workManagement(){
		return "production/workManage";
	}
	

	
	
	
	
}
