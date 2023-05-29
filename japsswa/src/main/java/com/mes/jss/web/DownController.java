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

@Controller
public class DownController {
	
	@Autowired FacilityService service;

	@GetMapping("/downtime")
	public String  downtime(Model model) {
		
		return "Facility/Downtime";
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

		service.setDownTime(vo);

		return "success";
		
	}
	
	@ResponseBody
	@RequestMapping("/facStatusAjax")
	public String updateFac(
			@RequestBody FacilityVO vo, Model model) {

		System.out.println(vo);
		service.updateFacList(vo);
		
		return "success";
				
	}
	
	@ResponseBody
	@RequestMapping("/newFacStatusAjax")
	public String newUpdateFac(@RequestBody FacilityVO vo, Model model) {
		
		System.out.println(vo);
		service.newUpdateFacList(vo);
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/startListAjax")
	public String startList(@RequestBody FacilityVO vo, Model model) {
		
		System.out.println(vo);
		service.updateFacList(vo);
		return "startSuccess";
	}
	
	@ResponseBody
	@RequestMapping("/startTimeAjax")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss a", timezone = "Asia/Seoul")
	public String updateStart(DowntimeVO vo, Model model) {
		
		if(service.updateStartDate(vo)) {
			return "success";
		}else {
			return "fail";
		}
	}	
	
	@ResponseBody
	@RequestMapping("/removeDowntimeAjax")
	public FacilityVO removeDownTime(@RequestBody FacilityVO vo) {
		 
		System.out.println(vo);
		
		service.removeDownTime(vo);
		service.newUpdateFacList(vo);
		
		return vo;			
	}
	
	@ResponseBody
	@RequestMapping("/modifyDownTimeAjax")
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
	
	@ResponseBody
	@GetMapping("/downDetailAjax")
	public List<DowntimeVO> downDetail(Model model){
		
		List<DowntimeVO> list = service.getDownDetail();
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/searchList")
	public List<FacilityVO> searchList(@RequestParam String facName){
		
		System.err.println(facName);
		
		List<FacilityVO> list = service.searchList(facName);
				
		return list;
	}
	
	
}
