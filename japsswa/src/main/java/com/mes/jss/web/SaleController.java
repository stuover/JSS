package com.mes.jss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired SaleService saleService;
	
	//등록화면
	@RequestMapping("/sale/insertorder")
	public String insertord() {
		return "sale/OrderReceipt";
	}
	
	//등록처리(주문)
	@RequestMapping(value="/sale/insertorder", method=RequestMethod.POST)
	public String ordRegister(OrderVO order) {
		saleService.orderInsert(order);
		saleService.orddetailInsert(order);
		return "sale/OrderReceipt";
	}
	
	
}
