package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/passList")
	@ResponseBody
	public List<FinishedVO> passListAjax(){
		List<FinishedVO> flist = finishedService.passList();
		
		return flist;
	}
	
	//체크한 품목 입고처리
	
	
}
