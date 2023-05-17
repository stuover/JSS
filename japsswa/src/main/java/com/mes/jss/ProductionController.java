package com.mes.jss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mes.jss.production.PlanVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;
import com.mes.jss.production.serviceImpl.PlanServiceImpl;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class ProductionController {
	

	@Autowired PlanService planService = new PlanServiceImpl();
	
	@RequestMapping("/planManage")
	public String orderInfo() {
		return "production/planManage";
	}

	@RequestMapping("/planManageAjax")
	@ResponseBody
	public List<PlanVO> orderInfoAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.planOrderInfo();
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
	
	
	
	
}
