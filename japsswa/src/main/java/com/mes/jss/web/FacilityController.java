package com.mes.jss.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.domain.saveFacVO;
import com.mes.jss.facility.service.FacilityService;

/*
 * 		박종만
 * 		설비 관리 페이지
 */
@Controller
public class FacilityController {

	@Autowired
	FacilityService service;

	// 설비

	@RequestMapping("/facility")
	public String facility() {

		return "Facility/failcity";
	}

	@RequestMapping("/AllfacilityAjax")
	@ResponseBody
	public List<FacilityVO> AllFacility() { // 설비 리스트 조회

		List<FacilityVO> list = service.getAllList();

		return list;
	}

	@RequestMapping("/searchFacility") // 설비 단건 조회
	@ResponseBody
	public List<FacilityVO> searchFacility(FacilityVO vo) {

		System.out.println(vo);
		List<FacilityVO> list = service.searchFacility(vo);

		return list;
	}

	@RequestMapping("/insertAjax") // 설비 등록
	@ResponseBody
	public FacilityVO insertAjax(@RequestBody FacilityVO vo) {

		service.saveFacility(vo);
		System.out.println(vo);
		
		return vo;

	}

	@RequestMapping("/modifyFacility") // 설비 정보수정
	@ResponseBody
	public FacilityVO modifyFacility(@RequestBody FacilityVO vo) {

		System.err.println(vo);
		service.modifyFacility(vo);

		return vo;
	}

	@RequestMapping("/RemoveFacility")	// 설비 정보 삭제
	@ResponseBody
	public FacilityVO RemoveFacility(@RequestBody FacilityVO vo) {
		
		System.out.println(vo);
		service.RemoveFacility(vo);
		
		return vo;
	}
	
	@RequestMapping("/test0001")
	public String test() {

		return "Facility/test1111";
	}

}
