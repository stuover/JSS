package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.saveFAcVO;
import com.mes.jss.facility.service.FacilityService;

/*
 * 		박종만
 * 		설비 관리 페이지
 */
@Controller
public class FacilityController {

	@Autowired FacilityService service;
	
	// 설비
	
	@RequestMapping("/facility")
	public String facility() {
		
		return "Facility/failcity";
	}
	
	@RequestMapping("/AllfacilityAjax")
	@ResponseBody
	public List<FacilityVO> AllFacility(){		// 설비 리스트 조회
		
		List<FacilityVO> list = service.getAllList();
		
		return list;
	}
	
	@RequestMapping("/searchFacility")		// 설비 단건 조회
	@ResponseBody
	public List<FacilityVO> searchFacility(@RequestParam String facCode){
		
		System.out.println(facCode);
		// vo로 받기 수정
		List<FacilityVO> list = service.searchFacility(facCode);
		
		return list;
	}
	
	@RequestMapping("/insertAjax")		// 설비 등록
	@ResponseBody
	public FacilityVO insertAjax(@RequestBody saveFAcVO vo ) {
		
		System.err.println(vo);

	//	FacilityVO upFac = data.getUpFac();
	//	FacilityVO downFac = data.getDownFac();
		
	//	service.saveFacility(upFac, downFac);
		
		
		return null;
		
	}
	
	@RequestMapping("/modifyFacility")		// 설비 정보수정
	@ResponseBody
	public FacilityVO modifyFacility(@RequestBody FacilityVO vo) {
		System.err.println(vo);
		System.err.println("123");
		service.modifyFacility(vo);

		
		return vo;
	}
	
}
