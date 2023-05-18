package com.mes.jss.quality.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.quality.domain.QualityVO;
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
	
	
	
	
	
	
	
	
}
