package com.mes.jss.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.service.CommonService;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryListVO;
import com.mes.jss.quality.domain.TestHistoryVO;
import com.mes.jss.quality.service.QualityService;



@Controller
@SpringBootApplication

public class QualityController {
	
	@Autowired
	QualityService qualityService;
	@Autowired
	CommonService commService;
	
	// 품질 검사 페이지
	
	@GetMapping("/mrlist")
	public String mrList(Model model, QualityVO vo) {
		
		return "material/materialStore";
						
	}
	
	// 품질 검사 아작스
	
	@ResponseBody
	@GetMapping("/mrlistAjax")
	public List<QualityVO> mrList() {
						
		List<QualityVO> list = qualityService.qlList();
	
				
		return list;
						
	}

	@RequestMapping("/quality")
	public String quality(Model model) {
		
		System.err.println(commService.getTypeList());
		model.addAttribute("typeCode",commService.getTypeList());

		return "quality/qualityInspection";
						
	}
	
	@ResponseBody
	@GetMapping("/qualityList")
	public List<QualityVO>  qualityList(SearchDTO dto) {
		
		
		return qualityService.qualityList(dto);
		
	}
	
	@ResponseBody
	@GetMapping("/getCheckList")
	public List<CheckListVO> getCheckList(@RequestParam String itemCode){
		return qualityService.getCheckList(itemCode);
		
	}
	
	@ResponseBody
	@RequestMapping("/completeTest")
	public String completeTest(@RequestBody TestHistoryListVO data, Principal principal) {
		System.err.println(data);
		qualityService.completeTest(data, Long.parseLong(principal.getName()));
		return null;
	}
	
	
	@RequestMapping("/passQuality")
	public String passQuality(Model model) {
		model.addAttribute("typeCode",commService.getTypeList());

		return "quality/passQuality";
						
	}
	
	@RequestMapping("/errQuality")
	public String errQuality(Model model) {
		model.addAttribute("typeCode",commService.getTypeList());

		return "quality/errQuality";
						
	}
	
	@ResponseBody
	@GetMapping("/passList")
	public List<QualityVO> passQualityList(SearchDTO dto){
		
		return qualityService.getPassQualityList(dto);
	}
	
	
	@ResponseBody
	@GetMapping("/errList")
	public List<QualityVO> errQualityList(SearchDTO dto){
		
		return qualityService.getErrQualityList(dto);
	}
	
	
	@ResponseBody
	@RequestMapping("/getHistoryList")
	public List<TestHistoryVO> getHistoryList(@RequestParam String testCode){
		
		return qualityService.getHistoryList(testCode);
	}
	
	
	@ResponseBody
	@RequestMapping("/removeTest")
	public String removeTest(@RequestBody TestHistoryListVO data) {
		qualityService.removeTest(data);
		return null;
	}
	

	
}
