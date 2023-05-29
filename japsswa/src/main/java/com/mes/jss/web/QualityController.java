package com.mes.jss.web;

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

import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.domain.QualityVO;
import com.mes.jss.quality.domain.TestHistoryListVO;
import com.mes.jss.quality.service.QualityService;



@Controller
@SpringBootApplication

public class QualityController {
	
	@Autowired
	QualityService qualityService;
	
	
	// 품질 검사 페이지
	
	@GetMapping("/mrlist")
	public String mrList(Model model, QualityVO vo) {
	
		
		return "/material/materialStore";
						
	}
	
	// 품질 검사 아작스
	
	@ResponseBody
	@GetMapping("/mrlistAjax")
	public List<QualityVO> mrList() {
						
		List<QualityVO> list = qualityService.qlList();
	
				
		return list;
						
	}

	@GetMapping("/quality")
	public String quality() {

		return "quality/qualityInspection";
						
	}
	
	@ResponseBody
	@GetMapping("/qualityList")
	public List<QualityVO>  qualityList() {
		
		
		return qualityService.qualityList();
		
	}
	
	@ResponseBody
	@GetMapping("/getCheckList")
	public List<CheckListVO> getCheckList(@RequestParam String itemCode){
		return qualityService.getCheckList(itemCode);
		
	}
	
	@ResponseBody
	@RequestMapping("/completeTest")
	public String completeTest(@RequestBody TestHistoryListVO data) {
		System.err.println(data);
		qualityService.completeTest(data);
		return null;
	}
	
	
	
	
	
	
}
