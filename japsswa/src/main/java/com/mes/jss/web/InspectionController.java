package com.mes.jss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.service.FacilityService;

@Controller
public class InspectionController {

	@Autowired FacilityService service;
	
	@ResponseBody
	@RequestMapping("/inspection")
	public String Inspection() {
				
		return "Facility/Inspection";
	}
}
