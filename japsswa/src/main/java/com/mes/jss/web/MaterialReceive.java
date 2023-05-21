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
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.sale.domain.CustomerVO;





@Controller
@SpringBootApplication

public class MaterialReceive {
	
	@Autowired
	MaterialService materialService;
	
	
	
	@GetMapping("/mslist")     //  자재 조회 페이지
	public String mrList(Model model, MrVO vo) {
	
		
		return "/material/material";
						
	}
	
	@ResponseBody
	@GetMapping("/mslistAjax")   // 자재 조회 아작스
	public List<MrVO> mrList() {
						
		List<MrVO> list = materialService.mrlist();
	
		
		
		return list;
						
	}
	
	@ResponseBody
	@RequestMapping("/searchListAjax")    // 모달창 검사 코드로 검색
	public List<MrVO> mrSearchList(@RequestParam String result){
		
		System.out.println(result);
		
		
		List<MrVO> list = materialService.searchList(result);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/mrCountAjax")     // 자재 재고 검색
	public List<MrVO> mrCountSearch(@RequestParam String result){
		System.out.println("조회 조건 : "+result);
		List<MrVO> list = materialService.mrCount(result);
		System.out.println("조회결과 : "+list);
		
		return list;
		
		
	}
	
	@ResponseBody
	@RequestMapping("/mrStore")     // 자재 입고 처리
	public MrVO mrStore(@RequestParam String testCode){
		
		System.out.println(testCode);
		
		MrVO result = materialService.mrIn(testCode);
		return result;
		
		
		
	}
	
	@GetMapping("/mrOrder")
	public String mrOrder() {   // 자재 발주 화면
		
		return "/material/materialOrder";
		
	}
	
	@ResponseBody
	@RequestMapping("/Orders")		 // 자재 발주 
	public MrOrderDetailVO orders(@RequestBody DetaiListlVO vo) {
		
		System.err.println(vo);
		
		materialService.orders(vo);
		
		for(int i = 0; i<vo.getList().size(); i++) {
			
			System.err.println(vo.getList().get(i));
		}
		
		
		
		/*for(MrOrderDetailVO list : vo.getList()) {
			System.err.println(list);
		}*/
		
		
		return null;
		
	}
	
	@ResponseBody
	@GetMapping("/mrCustomerAjax")     // 거래처 아작스
	public List<CustomerVO> CustomerList(){
		
		List<CustomerVO> list = materialService.cusSearch();
		return list;
		
	}
	
	@ResponseBody
	@RequestMapping("/searchCustomerAjax")    // 모달창 검사 코드로 검색
	public List<CustomerVO> CusSearchList(@RequestParam String result){
		
		System.out.println(result);
		
		
		
		List<CustomerVO> list = materialService.cusListSearch(result);
		return list;
		
		
		
	}
	
	
	
}
