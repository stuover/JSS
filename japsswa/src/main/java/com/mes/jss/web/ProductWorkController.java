package com.mes.jss.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.ProcessOrderVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.service.PlanService;
import com.mes.jss.production.service.WorkService;
import com.mes.jss.production.service.impl.PlanServiceImpl;
import com.mes.jss.production.service.impl.WorkServiceImpl;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class ProductWorkController {
	
	@Autowired WorkService workService = new WorkServiceImpl();

	@RequestMapping("/workManage")
	public String workManagement(){
		return "production/workManage";
	}
	

	@RequestMapping("/processInfoAjax")
	@ResponseBody
	public List<ProcessOrderVO> processInfoAjax(String code) {
		List<ProcessOrderVO> inputData = new ArrayList<ProcessOrderVO>();
		
		inputData = workService.processInfo(code);
		
		return inputData;
	}
	
	
	
}
