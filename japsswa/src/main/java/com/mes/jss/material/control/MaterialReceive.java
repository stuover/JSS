package com.mes.jss.material.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.service.MaterialService;





@Controller
@SpringBootApplication

public class MaterialReceive {
	
	@Autowired
	MaterialService materialService;
	
	
	
	@GetMapping("/mslist")     // 자재 조회 페이지
	public String mrList(Model model, MrVO vo) {
	
		
		return "/material/material";
						
	}
	
	@ResponseBody
	@GetMapping("/mslistAjax")   // 자재 조회 아작스
	public List<MrVO> mrList() {
						
		List<MrVO> list = materialService.mrlist();
	
		
		
		return list;
						
	}
	
	@ResponseBody
	@RequestMapping("/searchListAjax")    // 모달창 검사 코드로 검색
	public List<MrVO> mrSearchList(@RequestParam String result){
		
		System.out.println(result);
		
		
		List<MrVO> list = materialService.searchList(result);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/mrCountAjax")     // 자재 재고 검색
	public List<MrVO> mrCountSearch(@RequestParam String result){
		
		List<MrVO> list = materialService.mrCount(result);
		
		return list;
		
		
	}
	
	
	
	
	
	
	
}
