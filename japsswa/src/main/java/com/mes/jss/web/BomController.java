package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.BomListVO;
import com.mes.jss.basic.domain.BomVO;
import com.mes.jss.basic.domain.ItemVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.basic.service.BomService;
import com.mes.jss.basic.service.ItemService;
import com.mes.jss.basic.service.ProcessOrderService;
import com.mes.jss.basic.service.ProcessService;
import com.mes.jss.basic.service.impl.BomServiceImpl;
import com.mes.jss.basic.service.impl.ItemServiceImpl;
import com.mes.jss.basic.service.impl.ProcessOrderServiceImpl;
import com.mes.jss.basic.service.impl.ProcessServiceImpl;

@Controller
public class BomController {
	@Autowired ProcessOrderService proOrdSv = new ProcessOrderServiceImpl();
	@Autowired ProcessService proService = new ProcessServiceImpl();
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
	public List<BomVO>getBomOrd(@RequestParam String itemCode){
		


		return bomService.getBomList(itemCode);
	}
	
	@ResponseBody
	@RequestMapping("/searchItem")
	public List<ItemVO> searchItem(@RequestParam String itemName){
		System.err.println(itemName);
		return itemService.searchItem(itemName);
	}
	
	@GetMapping("/bomManage")
	public String register() {
		return "basic/bomManagement";
	}
	
	
	@ResponseBody
	@RequestMapping("/getProcess")
	public List<ProcessVO> getProcess(){
		
		return proService.getProcess();
	}

	@ResponseBody
	@RequestMapping ("/saveBom")
	public String saveBom(@RequestBody BomListVO save){
		System.err.println(save);
		bomService.saveBom(save);
		return "success";
		
	}
	
	@ResponseBody
	@RequestMapping ("/removeBom")
	public String removeBom(@RequestBody BomListVO dete){
		System.err.println(dete);
		bomService.remove(dete);
		return "success";
		
	}
	
	@ResponseBody
	@GetMapping("/getNumber")
	public String getNumber() {
		
		String number = bomService.getNumber();
		return number;
	}
	
	@ResponseBody
	@GetMapping("/getBomManageList")
	public List<BomVO> getBomManageList(@RequestParam String itemCode) {
		
		
		return bomService.getBomManageList(itemCode);
	}

}


























































