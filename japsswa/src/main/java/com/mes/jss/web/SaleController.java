package com.mes.jss.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.sale.domain.OrderVO;
import com.mes.jss.sale.domain.SaleListVO;
import com.mes.jss.sale.service.SaleService;

@Controller
public class SaleController {
	
	@Autowired SaleService saleService;
	
	//등록화면
	@RequestMapping("/sale/insertorder")
	public String insertord() {
		return "sale/OrderReceipt";
	}
	
	//거래처 모달 리스트
	@RequestMapping("/cModal")
	@ResponseBody
	public List<OrderVO> custModalListAjax(){
		List<OrderVO> mList = saleService.custModalList();
		
		return mList;
	}
	
	//품목 모달 리스트
	@RequestMapping("/itemNamelist")
	@ResponseBody
	public List<OrderVO> itemNamelistAjax(){
		List<OrderVO> item = saleService.itemNamelist();
		
		return item;
	}
	
	//거래처 검색
	@RequestMapping("/custList")
	@ResponseBody
	public List<OrderVO> custListAjax(@RequestParam String result){
		List<OrderVO> cust = saleService.custList(result);
		System.out.println(result);
		return cust;
	}
	
	//품목 검색
	@RequestMapping("/itemSearch")
	@ResponseBody
	public List<OrderVO> itemSearchAjax(@RequestParam String code){
		List<OrderVO> iSear = saleService.itemSearch(code);
		
		return iSear;
	}
	
	//거래처 자동 입력
	@RequestMapping("/custInfo")
	@ResponseBody
	public List<OrderVO> custInfoAjax(String customerId){
		List<OrderVO> info = saleService.custInfo(customerId);
		
		return info;
	}
	
	//품목코드 자동 입력
	@RequestMapping("/itemInfo")
	@ResponseBody
	public List<OrderVO> itemInfoAjax(String itemCode){
		List<OrderVO> iInfo = saleService.itemInfo(itemCode);
		
		return iInfo;
	}
	
	
	@RequestMapping("/entireRegister")
	@ResponseBody
	public OrderVO entRegisterAjax(@RequestBody SaleListVO listVo, Principal principal) {
		
		OrderVO commInfo = listVo.getCommInfo();
		commInfo.setEmpNo(Long.parseLong(principal.getName()));
		
		
		List<OrderVO> list = listVo.getList();
		saleService.entRegister(commInfo, list);
		return commInfo;
	}
	
	//수정 모달 리스트
	@RequestMapping("/custOrdModal")
	@ResponseBody
	public List<OrderVO> custOrdModalAjax(){
		List<OrderVO> oModal = saleService.custOrdModal();
		
		return oModal;
	} 
	
	//수정할때 접수완료상태 거래처 검색
	@RequestMapping("/custShowModal")
	@ResponseBody
	public List<OrderVO> custShowModalAjax(@RequestParam String oCode){
		List<OrderVO> slist = saleService.custShowModal(oCode);
		
		return slist;
	}
	
	//수정할때 기존 입력값 자동 입력
	/*
	 * @RequestMapping("/orderShow")
	 * 
	 * @ResponseBody public List<OrderVO> orderShowAjax(@RequestBody SaleListVO
	 * sList){
	 * 
	 * 
	 * 
	 * }
	 */
	
	

	

	
}
