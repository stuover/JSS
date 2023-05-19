package com.mes.jss.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.production.domain.PlanDatasVO;
import com.mes.jss.production.domain.PlanVO;
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
	public PlanVO savePlanAjax(@RequestBody PlanDatasVO data, Principal principal){
		System.out.println(data);
		PlanVO head =  data.getHead();
		head.setEmpNo(Long.parseLong(principal.getName()));
		
		List<PlanVO> list = data.getDetailList();
		planService.planSave(head, list);		
		return head;
	}
	
	
	@RequestMapping("/planSearchResultAjax")
	@ResponseBody
	public List<PlanVO> planSearchResultAjax(String planId) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.planSearchResult(planId);
	
		return inputData;
	}
	
	
	
}
