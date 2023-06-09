package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.InspectionVO;
import com.mes.jss.facility.service.FacilityService;

@Controller
public class InspectionController {

	@Autowired FacilityService service;
	
	
	@GetMapping("/inspection")
	public String Inspection(Model model) {
				model.addAttribute("facCode", service.getAllList());
				model.addAttribute("insReason", service.getDetailList("ins"));
				model.addAttribute("employee", service.getEmp("설비"));		
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
	
	
	@RequestMapping("/getSelectList")	// 점검 등록 - facCode 리스트 불러오기
	@ResponseBody
	public List<FacilityVO> getSelectList() {		
		
		return service.getSelectList();
	}
	
	
	
	
	@RequestMapping("/insertInsAjax")	// 비가동=점검 등록
	@ResponseBody
	public InspectionVO insertInsAjax(@RequestBody InspectionVO vo) {
		
		service.saveInspection(vo);
		System.out.println(vo);
		
		return vo;
	}
	
	@RequestMapping("/updateFacDate")	// facility 마지막 점검일 업데이트
	@ResponseBody
	public FacilityVO updateFacDate(@RequestBody FacilityVO vo) {
		
		System.out.println(vo);
		service.updateFacDate(vo);
		
		return vo;
	}
	
	@RequestMapping("/modifyInspection")	// 점검 내역 수정
	@ResponseBody
	public InspectionVO modifyInspection(@RequestBody InspectionVO vo) {
		
		System.out.println(vo);
		
		service.modifyInspection(vo);
		
		return vo;
	}
	
	@RequestMapping("/RemoveInspection")	// 점검 내역 삭제
	@ResponseBody
	public InspectionVO RemoveFacility(@RequestBody InspectionVO vo) {
		
		System.out.println(vo);
		service.RemoveInspection(vo);
		
		return vo;
	}
	
	@RequestMapping("/searchInsList")		// 점검 검색
	@ResponseBody
	public List<InspectionVO> searchInsList(InspectionVO vo){
		
		System.out.println(vo);
		
		List<InspectionVO> list = service.searchInsList(vo);
				
		return list;
	}
	
	
	
}
