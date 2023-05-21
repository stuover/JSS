package com.mes.jss.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
	
	@ResponseBody
	@RequestMapping("/modifyDetailsAjax")
	public CommVO modifyDetailsAjax(@RequestBody CommListVO listVo) {
		
		System.err.println(listVo);
		commService.modifyDetails(listVo);
		
		
		CommVO vo = new CommVO();
		
		return null;
	}
	
	
	
	
	
}
