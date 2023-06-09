package com.mes.jss.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.FinishedListVO;
import com.mes.jss.sale.domain.FinishedVO;
import com.mes.jss.sale.service.FinishedService;

@Controller
public class FinishedController {
	
	@Autowired FinishedService finishedService;
	
	//완제품 입고 관리 화면
	@RequestMapping("/finished")
	public String finished() {
		return "sale/Finished";
	}
	
	//작업완료시간이 존재하는 완제품의 합격량 리스트
	@RequestMapping("/passItem")
	@ResponseBody
	public List<FinishedVO> PassItemAjax(){
		List<FinishedVO> flist = finishedService.passItem();
		
		return flist;
	}
	
	//체크한 품목 입고처리
	@RequestMapping("/fRegister")
	@ResponseBody
	public FinishedVO fRegisterAjax(@RequestBody List<FinishedVO> flistvo){
		
		
		System.err.println(flistvo);
		
		finishedService.fRegister(flistvo);
		
		
		 
		 
		
		return null;
	}
	
	//입고처리된 품목 리스트(하단 그리드에 방금 입고처리한 품목 포함) 
	@RequestMapping("/storeInItem")
	@ResponseBody
	public List<FinishedVO> storeInItem(){
		List<FinishedVO> slist = finishedService.storeInItem();
		return slist;
	}
	
	//입고취소
	@RequestMapping("/delFinished")
	@ResponseBody
	public FinishedVO delFinished(@RequestBody FinishedListVO dlist) {
		List<FinishedVO> list = dlist.getFlist();
		finishedService.delFinished(list);
		return null;
	}
	
	//완제품 입고 조회 화면
	@RequestMapping("/storeInShow")
	public String storeInShow() {
		return "sale/finishedShow";
	}
	
	//주문서 전체 조회
	@RequestMapping("/entStoreIn")
	@ResponseBody
	public List<FinishedVO> entStoreInAjax(){
		List<FinishedVO> elist = finishedService.entStoreIn();
		return elist;
	}
	
}
