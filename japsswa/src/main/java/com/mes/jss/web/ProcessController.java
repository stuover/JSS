package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.DTO.SearchDTO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.basic.service.ProcessService;

@Controller
public class ProcessController {
	@Autowired ProcessService proService;
	
	
	@GetMapping("/process")
	public String process() {
		
		
		
		/// 테스트
		return "basic/process";
		
	}
	
	
	@ResponseBody
	@RequestMapping("/processList")
	public List<ProcessVO> processList (SearchDTO dto){
		System.err.println(dto);
		return proService.getList(dto);
	}
	
	
	@ResponseBody
	@RequestMapping("/getProCode")
	public ProcessVO getProCode (){
		ProcessVO proCode = proService.getProCode();
		System.err.println(proCode);
		return proCode;
	}

	
	@ResponseBody
	@RequestMapping("/addProcessAjax")
	public ProcessVO addProcessAjax(@RequestBody ProcessVO vo){
		proService.addProcess(vo);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/modProAjax")
	public ProcessVO modifyProcess(@RequestBody ProcessVO vo){
		proService.modifyProcess(vo);
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/removePro")
	public String removeItem(@RequestParam String proCode) {
		
		if(proService.removePro(proCode)) {
			return "success";
		}else {
			return "fail";
		}
	}
	
}
