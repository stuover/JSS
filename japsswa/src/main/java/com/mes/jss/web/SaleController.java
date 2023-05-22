package com.mes.jss.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;
import com.mes.jss.sale.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired SaleService saleService;
	
	//등록화면
	@RequestMapping("/sale/insertorder")
	public String insertord() {
		return "sale/OrderReceipt";
	}
	
	@RequestMapping("/itemNamelist")
	@ResponseBody
	public List<OrderVO> itemNamelistAjax(){
		List<OrderVO> item = new ArrayList<>();
		item = saleService.itemNamelist();
		
		return item;
	}
	
	@RequestMapping("/custList")
	@ResponseBody
	public List<OrderVO> custListAjax(@RequestParam String result){
		List<OrderVO> cust = saleService.custList(result);
		System.out.println(result);
		return cust;
	}
	
	@RequestMapping("/custInfo")
	@ResponseBody
	public List<OrderVO> custInfoAjax(String customerId){
		List<OrderVO> info = saleService.custInfo(customerId);
		
		return info;
	}
	
	@RequestMapping("/entireRegister")
	@ResponseBody
	public OrderVO entRegisterAjax(@RequestBody SaleListVO listVo, Principal principal) {
		
		OrderVO commInfo = listVo.getCommInfo();
		commInfo.setEmpNo(Long.parseLong(principal.getName()));
		
		
		List<OrderVO> list = listVo.getList();
		saleService.entRegister(commInfo, list);
		return commInfo;
	}
	

	

	
}
