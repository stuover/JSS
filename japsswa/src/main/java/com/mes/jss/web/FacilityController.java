package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;
import com.mes.jss.facility.service.impl.FacilityServiceimpl;

@Controller
public class FacilityController {
	
	@Autowired FacilityService service = new FacilityServiceimpl();

	@GetMapping("/Facility")
	public String  getFacility(Model model) {
		
		model.addAttribute("facList", service.getList());
		return "Facility/Facility";
	}
	
	@ResponseBody
	@GetMapping("/Facilityajax")
	public List<FacilityVO> facility(){
		
		List<FacilityVO> list = service.getList();				
		return list;	
		
	}
	
	@ResponseBody
	@GetMapping("/Downtimeajax")
	public List<DowntimeVO> downtime(){
			
		List<DowntimeVO> downlist = service.getDownList();
		return downlist;	
		
	}
	
	
}
