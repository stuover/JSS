package com.mes.jss.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.ItemVO;
import com.mes.jss.basic.service.BomService;
import com.mes.jss.basic.service.ItemService;
import com.mes.jss.basic.service.ProcessOrderService;
import com.mes.jss.basic.service.impl.BomServiceImpl;
import com.mes.jss.basic.service.impl.ItemServiceImpl;
import com.mes.jss.basic.service.impl.ProcessOrderServiceImpl;

@Controller
public class BomController {
	@Autowired ProcessOrderService proOrdSv = new ProcessOrderServiceImpl();
	@Autowired BomService bomService = new BomServiceImpl();
	@Autowired ItemService itemService = new ItemServiceImpl();
	
	@GetMapping("/bom")
	public String bom(){
		return "basic/bom";
	}
	
	// 전체 리스트
	@ResponseBody
	@RequestMapping("/getItemList")
	public List<ItemVO> getItemList(){
		return itemService.getAllItemList();
	}
	
	
	@ResponseBody
	@RequestMapping("/getItemDetaList")
	public List<ItemVO> getItemDetaList(@RequestParam String itemType){
			return itemService.getItemList(itemType);
	}
	
	
	
	@ResponseBody
	@RequestMapping("/getBomOrd")
	public Map<String, List<Object>> getBomOrd(@RequestParam String itemCode){
		
		Map<String, List<Object>> map = new HashMap<>();
		System.err.println(itemCode);
		map.put("bom", bomService.getBomList(itemCode));
		map.put("process", proOrdSv.getProList(itemCode));
		System.err.println(map);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/searchItem")
	public List<ItemVO> searchItem(@RequestParam String itemName){
		System.err.println(itemName);
		return itemService.searchItem(itemName);
	}
	
	@GetMapping("/bom/register")
	public String register() {

		return "basic/registerBom";
	}


}
