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

import com.mes.jss.facility.domain.DowntimeVO;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;
import com.mes.jss.facility.service.impl.FacilityServiceimpl;

@Controller
public class FacilityController {
	
	@Autowired FacilityService service = new FacilityServiceimpl();

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
		
		System.err.println(vo);
		
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
	public String updateStart(DowntimeVO vo, Model model) {
		
		if(service.updateStartDate(vo)) {
			return "success";
		}else {
			return "fail";
		}
	}
	
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
	@RequestMapping("/removeDowntimeAjax")
	public String removeDownTime(String downCode) {
		
		System.out.println(downCode);
		
		if(service.removeDownTime(downCode)) {
			return "success";
		}else {
			return "fail";
		}
		
				
	}
	
	
	
}
