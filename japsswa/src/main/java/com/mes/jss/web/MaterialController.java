package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.material.domain.DetaiListlVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.sale.domain.CustomerVO;





@Controller
@SpringBootApplication

public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	
//  자재 조회 페이지
	
	@GetMapping("/mslist")     
	public String mrList(Model model, MrVO vo) {
			
		return "/material/material";
						
	}
	
// 자재 조회 아작스	
	
	@ResponseBody
	@GetMapping("/mslistAjax")   
	public List<MrVO> mrList() {
						
		List<MrVO> list = materialService.mrlist();
		
		return list;
						
	}

	
 // 모달창 검사 코드로 검색
	
	@ResponseBody
	@RequestMapping("/searchListAjax")   
	public List<MrVO> mrSearchList(@RequestParam String result){
		
				
		List<MrVO> list = materialService.searchList(result);
		return list;
	}

	
 // 자재 재고 검색
	
	@ResponseBody
	@RequestMapping("/mrCountAjax")    
	public List<MrVO> mrCountSearch(@RequestParam String result){
		
		List<MrVO> list = materialService.mrCount(result);
			
		return list;
			
	}

// 자재 입고 처리
	
	@ResponseBody
	@RequestMapping("/mrStore")     
	public MrVO mrStore(@RequestParam String testCode){
		
		System.out.println(testCode);
		
		MrVO result = materialService.mrIn(testCode);
		return result;
		
	}

// 자재 발주 화면
	
	@GetMapping("/mrOrder")
	public String mrOrder() {   
		
		return "/material/materialOrder";
		
	}

 // 자재 발주 	
	
	@ResponseBody
	@RequestMapping("/Orders")		
	public MrOrderDetailVO orders(@RequestBody DetaiListlVO vo) {
						
		materialService.orders(vo);
				
		return null;
		
	}

// 거래처 아작스
	
	@ResponseBody
	@GetMapping("/mrCustomerAjax")     
	public List<CustomerVO> CustomerList(){
		
		List<CustomerVO> list = materialService.cusSearch();
		return list;
		
	}

// 모달창 검사 코드로 검색	
	
	@ResponseBody
	@RequestMapping("/searchCustomerAjax")    
	public List<CustomerVO> CusSearchList(@RequestParam String result){
		
		System.out.println(result);
				
		List<CustomerVO> list = materialService.cusListSearch(result);
		return list;
		
	}

// 자재 발주 조회 화면창 
	@GetMapping("/mrOrderList")
	public String MrOrderList() {
		
		
		return "/material/materialOrderList";
		
	}
	
// 자재 발주 조회
	@ResponseBody
	@GetMapping("/mrOrderListAjax")
	public List<MrOrderVO> MrOrderMain(){
		
		List<MrOrderVO> list = materialService.OrderMain();
		
		return list;
		
	}

// 자재 발주 상세 조회
	@ResponseBody
	@GetMapping("/mrOrderDetailAjax")
	public List<MrOrderDetailVO> mrOrderDetail(){
		
		List<MrOrderDetailVO>  list = materialService.OrderDetail();
		
		return list;
	}
	
	
// 자재 조정 화면
	
	@GetMapping("/mrAdjustment")
	public String MrAdjustment(){
		
		return "/material/materialAdjustment";
		
	}

	
// 자재 조정 리스트
	@ResponseBody
	@GetMapping("/mrAdjustmentAjax")
	public List<MrAdjustmentVO> MrAdmList(){
		
		List<MrAdjustmentVO> list = materialService.admList();
		
		return list;
		
	}
	
	
	
	
}