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

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class ProductionController {
	
	@Autowired PlanMapper plan;
	
	@RequestMapping("/planManage")
	public String orderInfo() {
		return "production/planManage";
	}

	@RequestMapping(value = "/planManageAjax")
	@ResponseBody
	public List<PlanVO> orderInfoAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = plan.planOrderInfo();
		log.info("inputData" + inputData);
	
		
		return inputData;
	}
	
	
	
}
