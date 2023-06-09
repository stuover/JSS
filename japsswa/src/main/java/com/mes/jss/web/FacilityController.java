package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.service.EmployeesService;
import com.mes.jss.facility.domain.FacilityVO;
import com.mes.jss.facility.service.FacilityService;

/*
 * 		박종만
 * 		설비 관리 페이지
 */
@Controller
public class FacilityController {

	@Autowired
	FacilityService service;
	@Autowired
	EmployeesService empService;

	// 설비
	@GetMapping("/facility")
	public String facility(Model model) {

		model.addAttribute("facFunction", service.getDetailList("fac"));
		model.addAttribute("employee", service.getEmp("설비"));
		
		System.err.println(service.getEmp("설비"));
		//SearchDTO dto = new SearchDTO();
		//dto.setSearchSel("설비");
		//model.addAttribute("empName", empService.getEmpList(dto));
		//System.err.println( empService.getEmpList(dto));
		
		//String Key = "empName"
		//model.addAttribute(key, empNAme);
		
		//model.addAttribute("operType", basicService.commGroupList(key));
		
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
