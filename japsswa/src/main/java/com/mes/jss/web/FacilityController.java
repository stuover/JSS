package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;
import com.mes.jss.facility.service.impl.FacilityServiceimpl;

@Controller
public class FacilityController {

	@Autowired FacilityService service = new FacilityServiceimpl();
	
	// 설비
	
	@RequestMapping("/facility")
	public String facility() {
		
		return "Facility/failcity";
	}
	
	@ResponseBody
	@RequestMapping("/AllfacilityAjax")
	public List<FacilityVO> AllFacility(){
		
		List<FacilityVO> list = service.getAllList();
		
		return list;
	}
}
