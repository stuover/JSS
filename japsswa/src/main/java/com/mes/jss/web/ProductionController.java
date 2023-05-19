package com.mes.jss.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;
import com.mes.jss.production.service.impl.PlanServiceImpl;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class ProductionController {
	

	@Autowired PlanService planService = new PlanServiceImpl();
	
	@RequestMapping("/planManage")
	public String orderInfo() {
		return "production/planManage";
	}

	@RequestMapping("/itemListInfoAjax")
	@ResponseBody
	public List<PlanVO> itemListInfoAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemListInfo();
		log.info("inputData" + inputData);
	
		
		return inputData;
	}
	
	@RequestMapping("/modalPlanListAjax")
	@ResponseBody
	public List<PlanVO> modalPlanListAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.modalPlanList();
	
		return inputData;
	}

	
	@RequestMapping("/savePlanAjax")
	@ResponseBody	
	public ResponseEntity<HttpStatus> savePlanAjax(PlanVO vo){
		System.out.println("------------------------------------------------------------");
		System.out.println(vo);
		System.out.println("------------------------------------------------------------");
		planService.planSave(vo);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@RequestMapping("/planSearchResultAjax")
	@ResponseBody
	public List<PlanVO> planSearchResultAjax(String planId) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.planSearchResult(planId);
	
		return inputData;
	}
	
	
	
}
