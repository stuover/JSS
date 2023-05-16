package com.mes.jss.sale.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mes.jss.sale.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired SaleService saleService;
	
	@RequestMapping("/sale/insertorder")
	public String insertord() {
		return "sale/OrderReceipt";
	}
	
}
