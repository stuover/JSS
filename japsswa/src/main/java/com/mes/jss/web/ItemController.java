package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.CommVO;
import com.mes.jss.basic.domain.ItemVO;
import com.mes.jss.basic.service.CommonService;
import com.mes.jss.basic.service.ItemService;
import com.mes.jss.quality.domain.CheckListVO;
import com.mes.jss.quality.service.QualityService;

@Controller
public class ItemController {
	@Autowired ItemService itemService;
	@Autowired CommonService commService;
	@Autowired QualityService qcService;
	
	//  부분검색
	@ResponseBody
	@RequestMapping("/itemList")
	public List<ItemVO> itemList(@RequestParam String val, String search){
		System.err.println(val);
		if(val == null || val.equals("null")) {
			return itemAllList();
		}{
			return itemService.getItemList(val);
		}
	}
	
	// 전체 리스트
	@ResponseBody
	@RequestMapping("/itemAllList")
	public List<ItemVO> itemAllList(){
		System.err.println(itemService.getAllItemList());
		return itemService.getAllItemList();
	}
	
	
	// 타임리프
	@RequestMapping("/item")
	public String process(Model model){		
		model.addAttribute("typeCode",commService.getTypeList());
		return "basic/item";
	}
	
	// 품목코드 불러오기
	@ResponseBody
	@RequestMapping("/getItemCode")
	public ItemVO getItemCode() {
		ItemVO vo = itemService.getItemCode();
		return vo;
	}
	
	
	@ResponseBody
	@RequestMapping("/addItemAjax")
	public ItemVO addItemAjax(@RequestBody ItemVO vo) {
		itemService.addItem(vo);		
		return vo;
	}

	
	@ResponseBody
	@RequestMapping("/modItemAjax")
	public ItemVO modItemAjax(@RequestBody ItemVO vo) {
		System.err.println(vo);
		itemService.modifyItem(vo);		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam String itemCode) {
		
		if(itemService.removeItem(itemCode)) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/saveItemQuality")
	public List<CheckListVO> saveItemQuality(@RequestBody List<CheckListVO> vo){
		System.err.println(vo);

		return 	qcService.updateItemQuality(vo);

	}

	@ResponseBody
	@RequestMapping("/removeQualityList")
	public List<CheckListVO> removeQualityList(@RequestBody List<CheckListVO> vo){
		System.err.println(vo);

		return 	qcService.removeItemQuality(vo);

	}
	
}
