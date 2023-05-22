package com.mes.jss.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mes.jss.basic.service.ItemService;
import com.mes.jss.basic.service.impl.ItemServiceImpl;

@Controller
public class ItemControll {
	@Autowired ItemService itemService = new ItemServiceImpl();
	

	@GetMapping("/item")
	public String item() {
		
		return "basic/item";
	}
}
