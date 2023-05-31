package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	//상단 그리드에 입고완료 상태 품목 리스트
	@RequestMapping("/finishedList")
	@ResponseBody
	public List<ReleaseVO> finishedListAjax(){
		List<ReleaseVO> tlist = releaseService.finishedList();
		
		return tlist;
	}
	
	
}
