package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;
import com.mes.jss.facility.service.impl.FacilityServiceimpl;

/*
 * 박종만
 * 비가동 관리
 */
@Controller
public class DownController {
	
	@Autowired FacilityService service;

	@GetMapping("/downtime")
	public String  downtime(Model model) {
		
		return "Facility/Downtime";
	}	
	
	@GetMapping("/facilityAjax")		// 전체 설비 리스트 조회
	@ResponseBody
	public List<FacilityVO> facility(){
		
		List<FacilityVO> list = service.getList();				
		return list;
		
	}
	
	@GetMapping("/downtimeAjax")		// 비가동 리스트 조회
	@ResponseBody
	public List<DowntimeVO> downtime(){
			
		List<DowntimeVO> downlist = service.getDownList();
		
		return downlist;	
		
	}
	
	// 리턴받기 매퍼에서 수정 필요
	@RequestMapping("/downListAjax")		// 설비 비가동 등록 
	public@ResponseBody  String register(DowntimeVO vo) {

		service.setDownTime(vo);

		return "success";
		
	}
	
	@RequestMapping("/facStatusAjax")		// 비가동시 설비 가동상태 변경
	@ResponseBody
	public String updateFac(@RequestBody FacilityVO vo) {

		System.out.println(vo);
		service.updateFacList(vo);
		
		return "success";
				
	}
	
	@RequestMapping("/newFacStatusAjax")		// 가동시,삭제시 설비 가동상태 변경
	@ResponseBody
	public String newUpdateFac(@RequestBody FacilityVO vo) {
		
		System.out.println(vo);
		service.newUpdateFacList(vo);
		
		return "success";
	}
		
	@RequestMapping("/startTimeAjax")		// 가동일시 추가
	@ResponseBody
	public String updateStart(DowntimeVO vo, Model model) {
		
		if(service.updateStartDate(vo)) {
			return "success";
		}else {
			return "fail";
		}
	}	
	
	@RequestMapping("/removeDowntimeAjax")		// 비가동 내역 삭제
	@ResponseBody
	public FacilityVO removeDownTime(@RequestBody FacilityVO vo) {
		 
		System.out.println(vo);
		
		service.removeDownTime(vo);
		service.newUpdateFacList(vo);
		
		return vo;			
	}
	
	@RequestMapping("/modifyDownTimeAjax")		// 비가동내역 수정 
	@ResponseBody
	public DowntimeVO modifyDownTime(@RequestBody DowntimeVO vo) {
		
		service.modifyDownTime(vo);		
		System.out.println(vo);
		
		return vo;
	}
	
	
	
	// 설비 비가동 내역
	
	@RequestMapping("/downDetail")
	public String getDowndetail(Model model) {
				
		return "Facility/DownDetail";
	}
	
	@GetMapping("/downDetailAjax")		// 비가동 내역 조회
	@ResponseBody
	public List<DowntimeVO> downDetail(Model model){
		
		List<DowntimeVO> list = service.getDownDetail();
		
		return list;
	}
	
	@RequestMapping("/searchList")		// 비가동 내역 단건 검색
	@ResponseBody
	public List<FacilityVO> searchList(@RequestParam String facName){
		
		System.err.println(facName);
		
		List<FacilityVO> list = service.searchList(facName);
				
		return list;
	}
	
	
}
