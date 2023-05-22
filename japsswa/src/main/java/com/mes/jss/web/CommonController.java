package com.mes.jss.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.annotation.RequestScope;

import com.mes.jss.basic.domain.CommListVO;
import com.mes.jss.basic.domain.CommVO;
import com.mes.jss.basic.service.CommonService;
import com.mes.jss.basic.service.impl.CommonServiceImpl;

@Controller
public class CommonController {

	@Autowired 
	CommonService commService = new CommonServiceImpl();
	
	@GetMapping("/common")
	public String Common() {
		
		return "basic/common";
	}
	
	
	@ResponseBody
	@GetMapping("/commAjax")
	public List<CommVO> commAjax(){
		
		List<CommVO> list = commService.getCommListe();
		
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/detailAjax")
	public List<CommVO> detailAjax(@RequestParam String commCode, Model model){
		List<CommVO> list = commService.getDetaList(commCode);
		if(list.size() == 0) {
			List<CommVO> fail = new ArrayList<>();
			return fail;
		}else {
			return list;

		}
		
	}
	
	
	// 공통코드 상세모달 저장
	@ResponseBody
	@RequestMapping("/modifyDetailsAjax")
	public CommVO modifyDetailsAjax(@RequestBody CommListVO listVo) {
		
		System.err.println(listVo);
		commService.modifyDetails(listVo);
		
		
		CommVO vo = new CommVO();
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/removeDetailsAjax")
	public CommVO removeDetailsAjax(@RequestBody CommListVO listVo) {
		
		System.err.println(listVo);
		commService.removeDetails(listVo);

		CommVO vo = new CommVO();
		
		return vo;
	}
	
	
	@ResponseBody
	@RequestMapping("/commSearchAjax")
	public CommVO commSearchAjax(@RequestParam String commCode) {
		CommVO vo = commService.getCommCode(commCode);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/addCommCode")
	public String addCommCode(CommVO vo){
		
		if(commService.searchComm(vo.getCommCode())) {
			return "fail";
		}else {
			commService.addCommCode(vo);
			return "success";
		}

	}
	
	@ResponseBody
	@RequestMapping("/removeCommCode")
	public String removeCommCode( CommVO vo) {
		
		System.err.println(vo.getCommCode());
		commService.removeCommCode(vo.getCommCode());
		
		if(commService.searchComm(vo.getCommCode())) {
			return "fail";
		}else { 
			return "success";
		}
		
	}

	
	
}
