package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;
import com.mes.jss.facility.service.impl.FacilityServiceimpl;

@Controller
public class FacilityController {
	
	@Autowired FacilityService service = new FacilityServiceimpl();

	@GetMapping("/facility")		
	public String  getFacility(Model model) {
		
		model.addAttribute("facList", service.getList());
		return "Facility/Facility";
	}
	
	@ResponseBody
	@GetMapping("/facilityAjax")		// 설비 리스트 조회
	public List<FacilityVO> facility(){
		
		List<FacilityVO> list = service.getList();				
		return list;	
		
	}
	
	@ResponseBody
	@GetMapping("/downtimeAjax")		// 비가동리스트 조회
	public List<DowntimeVO> downtime(){
			
		List<DowntimeVO> downlist = service.getDownList();
		return downlist;	
		
	}
	
	@ResponseBody
	@RequestMapping("/downListAjax")
	public String register(DowntimeVO vo, Model model) {
		
		System.err.println(vo);
		
		service.setDownTime(vo);
		
		return "success";
		
	}
	
	@ResponseBody
	@RequestMapping("/facStatusAjax")
	public String updateFac(FacilityVO vo, Model model) {

		System.out.println("============");
		System.out.println(vo);
		System.out.println("============");
		service.updateFacList(vo);
		
		return "success";
				
	}
	
	
}
