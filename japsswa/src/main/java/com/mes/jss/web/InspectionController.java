package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.InspectionVO;
import com.mes.jss.facility.service.FacilityService;

@Controller
public class InspectionController {

	@Autowired FacilityService service;
	
	
	@GetMapping("/inspection")
	public String Inspection() {
				
		return "Facility/Inspection";
	}
	
	@GetMapping("/beforeInsList")
	@ResponseBody
	public List<InspectionVO> beforeInspectionList(){
		
		List<InspectionVO> list = service.getbeforeInsList();
		
		return list;
	}
	
	@RequestMapping("/inspectionList")
	@ResponseBody
	public List<InspectionVO> InspectionList(){
		
		List<InspectionVO> list = service.getInspectionList();
		
		return list;
	}
	
	
	
	
	
	
	
}
