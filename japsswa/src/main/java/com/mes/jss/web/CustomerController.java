package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.basic.domain.TransListVO;
import com.mes.jss.basic.domain.TransactionItemVO;
import com.mes.jss.basic.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired CustomerService cusService;
	
	
	@GetMapping("/customer")
	public String  downtime(Model model) {
		
		return "basic/customer";
	}	
	
	@ResponseBody
	@GetMapping("/custList")
	public List<CustomerVO> custList(){
		
		return cusService.getList();
	}
	
	@ResponseBody
	@RequestMapping("/saveCusDeta")
	public String saveCusDeta(@RequestBody TransListVO vo) {
		System.err.println(vo);
		cusService.saveCusDeta(vo);
		return "success";
	}
	
	@ResponseBody
	@GetMapping("/transList")
	public List<TransactionItemVO> transList(@RequestParam String cusId){
		
		return cusService.getTranList(cusId);
	}
	
	
}
