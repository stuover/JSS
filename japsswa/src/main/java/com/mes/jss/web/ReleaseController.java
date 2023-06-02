package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.ReleaseVO;
import com.mes.jss.sale.service.ReleaseService;

@Controller
public class ReleaseController {
	
	@Autowired ReleaseService releaseService;
	
	//출고관리화면
	@GetMapping("/release")
	public String release() {
		return "sale/Release";
	}

	//품목검색 -> 상단 그리드 자동입력
	@RequestMapping("/showTopList")
	@ResponseBody
	public List<ReleaseVO> showTopListAjax(@RequestParam String itemName){
		List<ReleaseVO> tlist = releaseService.showTopList(itemName);
		return tlist;
	}
	
}
