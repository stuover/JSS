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

/*
 * 개발자 : 강현영
 * 주문서 관리
 */
@Controller
public class SaleController {
	
	@Autowired SaleService saleService;
	
	//등록화면
	@RequestMapping("/insertorder")
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
	
	//주문 등록
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
		List<OrderVO> oModal = saleService.custOrdModal();  //접수완료건 조회
		
		return oModal;
	} 
	
	//수정할때 모달내에서 거래처 검색
	@RequestMapping("/custShowModal")
	@ResponseBody
	public List<OrderVO> custShowModalAjax(@RequestParam String oCode){
		List<OrderVO> slist = saleService.custShowModal(oCode);
		
		return slist;
	}
	
	//수정할때 기존 입력값 자동 입력(주문)
	@RequestMapping("/orderShow")
	@ResponseBody
	public List<OrderVO> orderShowAjax(OrderVO orderVo){
		List<OrderVO> oList = saleService.orderShow(orderVo);
		
		return oList;
	}
	
	//수정할때 기존 입력값 자동 입력(주문 상세)
	@RequestMapping("/ordDetShow")
	@ResponseBody
	public List<OrderVO> ordDetShowAjax(@RequestParam(name = "ordId") String orderId){
		List<OrderVO> dList = saleService.ordDetShow(orderId);
		
		return dList;
	}
	
	//주문서 삭제
	@RequestMapping("/entDel")
	@ResponseBody
	public OrderVO entDelAjax(@RequestParam(name = "ordId") String delId) {
		
		saleService.entDel(delId);
		
		return null;
	}
	
	//주문서 품목 삭제
	@RequestMapping("/delDet")
	@ResponseBody
	public OrderVO delDetAjax(@RequestBody SaleListVO svo) {
		
		//List<OrderVO> lists = saleService.delDet(svo);
		List<OrderVO> list = svo.getList();
		System.err.println(svo);
		saleService.delDet(list);
		return null;
		
	}
	
	//주문서 수정
	@RequestMapping("/ordUpdate")
	@ResponseBody
	public OrderVO ordUpdate(@RequestBody SaleListVO slist) {		

		saleService.ordUpdate(slist);
		return null;
		
	}
	
	
	
	
	

	

	
}
