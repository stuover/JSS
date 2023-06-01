package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/beforeInsList")		// 비가동사유가 점검 and 등록전인 리스트
	@ResponseBody
	public List<InspectionVO> beforeInspectionList(){ 
		
		List<InspectionVO> list = service.getbeforeInsList();
		
		return list;
	}
	
	@RequestMapping("/inspectionList")		// 점검 내역 리스트
	@ResponseBody
	public List<InspectionVO> InspectionList(){
		
		List<InspectionVO> list = service.getInspectionList();
		
		return list;
	}
	
	@RequestMapping("/insertInsAjax")	// 점검 등록
	@ResponseBody
	public InspectionVO insertInsAjax(@RequestBody InspectionVO vo) {
		
		service.saveInspection(vo);
		System.out.println(vo);
		
		return vo;
	}
	
	@RequestMapping("/modifyInspection")	// 점검 내역 수정
	@ResponseBody
	public InspectionVO modifyInspection(@RequestBody InspectionVO vo) {
		
		System.out.println(vo);
		service.modifyInspection(vo);
		
		return vo;
	}
	
	
	
	
	
	
}
