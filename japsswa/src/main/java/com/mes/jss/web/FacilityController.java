package com.mes.jss.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<FacilityVO> AllFacility(){	// 설비 조회
		
		List<FacilityVO> list = service.getAllList();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/searchFacility")
	public List<FacilityVO> searchFacility(@RequestParam String facCode){
		
		System.out.println(facCode);
		
		List<FacilityVO> list = service.searchFacility(facCode);
		
		return list;
	}
	
	@RequestMapping("/insertAjax")
	@ResponseBody
	public FacilityVO insertAjax(@RequestBody FacilityVO data) {
		
		//FacilityVO upFac = data.get
		//System.out.println(vo);
		
		return null;
		
	}
	
}
