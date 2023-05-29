package com.mes.jss.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.service.PerformanceService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PerformanceController {
	
	@Autowired PerformanceService performanceService;
	
	@RequestMapping("/performanceManage")
	public String performanceMangement() {
		
		return "production/performanceManage";
	}
	
	
	@RequestMapping("/searchProcessResultAjax")
	public List<ProcessVO> searchProcessResultAjax (){
		List<ProcessVO> result = new ArrayList<>();
		result = performanceService.processList();
		
		return result;
	}
	
	
	
}
