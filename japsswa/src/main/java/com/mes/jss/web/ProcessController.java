package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.basic.service.ProcessService;
import com.mes.jss.basic.service.impl.ProcessServiceImpl;

@Controller
public class ProcessController {
	@Autowired ProcessService proService = new ProcessServiceImpl();
	
	
	@GetMapping("/process")
	public String process() {
		
		return "basic/Process";
		
	}
	
	
	@ResponseBody
	@RequestMapping("/processList")
	public List<ProcessVO> processList (){
		return proService.getList();
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