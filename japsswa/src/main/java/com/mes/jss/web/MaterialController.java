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

import com.mes.jss.material.domain.AdjustmentListVO;
import com.mes.jss.material.domain.DetaiListlVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrErrorVO;
import com.mes.jss.material.domain.MrListVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrReturnVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.domain.ReturnListVO;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.production.domain.PerformanceListVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.quality.domain.QualityListVO;
import com.mes.jss.quality.domain.QualityVO;
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

 
	// 자재 재고 리스트
	@ResponseBody
	@GetMapping("/mrCount")
	public List<MrVO> mrCount(){
		
		List<MrVO> list = materialService.mrCountList();
		
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
	public MrVO mrStore(@RequestBody QualityListVO vo){
		
		System.err.println(vo);
		
		materialService.mrIn(vo);
		
		return null;
		
	}
	
// 자재 입고 취소
	
	@ResponseBody
	@RequestMapping("/mrStoreCancle")
	public MrVO mrCancle(@RequestBody MrListVO vo) {
		
		materialService.mrDelete(vo);
		
		return null;
		
	}
	
// 생산 실적 리스트 
	
	@ResponseBody
	@GetMapping("/mrPerformance")
	public List<PerformanceVO> mrPerformance(){
		
		List<PerformanceVO> list = materialService.mrPerformanceList();
		
		return list;
		
	}
	
// 반제품 입고
	
	@ResponseBody
	@RequestMapping("/halfMrInsert")
	public MrVO halfMrInsert(@RequestBody PerformanceListVO vo) {
		
		materialService.halfIn(vo);
		
		return null;
		
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
	@RequestMapping("/mrOrderDetailAjax")
	public List<MrOrderDetailVO> mrOrderDetail(@RequestParam String result){
		
		List<MrOrderDetailVO>  list = materialService.OrderDetail(result);
		
		return list;
	}
	
	
// 자재 조정 화면
	
	@GetMapping("/mrAdjustment")
	public String MrAdjustment(){
		
		return "/material/materialAdjustment";
		
	}


// 자재 조정 대상 리스트
	
	@ResponseBody
	@GetMapping("/mrAdmAjax")
	public List<MrAdjustmentVO> MrAdList(){
		
		List<MrAdjustmentVO> list = materialService.adList();
		
		return list;
	}
	
	
// 자재 조정 리스트
	
	@ResponseBody
	@GetMapping("/mrAdjustmentAjax")
	public List<MrAdjustmentVO> MrAdmList(){
		
		List<MrAdjustmentVO> list = materialService.admList();
		
		return list;
		
	}

	//자재 조정 등록
	
	@ResponseBody
	@RequestMapping("/mrAdmInsert")
	public MrAdjustmentVO MrAdmInsert(@RequestBody AdjustmentListVO vo) {
		
		materialService.admIn(vo);
		
		return null;
		
	}
	
	//자재 조정 입고
	
	@ResponseBody
	@RequestMapping("/mrAdmIn")
	public MrAdjustmentVO mrAdmIn(@RequestBody AdjustmentListVO vo) {
		
		System.out.println(vo);
		
		materialService.admInsert(vo);
		
		return null;
	}
	
	//자재 조정 출고
	
	@ResponseBody
	@RequestMapping("/mrAdmRel")
	public MrAdjustmentVO mrAdmRel(@RequestBody AdjustmentListVO vo) {
		
		materialService.admRelease(vo);
		
		return null;
	}
	
	
// 자재 반품 화면
	
	@GetMapping("/mrReturn")
	public String mrReturn() {
		
		return "/material/materialReturn";
	}
	
// 자재 반품 품질 조회
	
	@ResponseBody
	@GetMapping("/mrReturnListAjax")
	public List<QualityVO> mrReturnList(){
		List<QualityVO> list = materialService.retList();
		
		return list;
	}
	
// 자재 반품 조회
	
	@ResponseBody
	@GetMapping("/mrReturnAjax")
	public List<MrReturnVO> mrReturnGetList(){
		
		List<MrReturnVO> list = materialService.returnList();
		
		return list;
		
	}

// 자재 반품 등록
	@ResponseBody
	@RequestMapping("/mrReturnInsert")
	public MrReturnVO mrReturnInsert(@RequestBody ReturnListVO vo){
		
		materialService.returnIn(vo);
		return null;
		
	}


	
	
 //  자재 불량 화면
	
	@GetMapping("/mrError")
	public String mrError() {
		
		return "/material/materialError";
	}
	
	
  // 자재 불량 리스트
	
	@ResponseBody
	@GetMapping("/mrErrorAjax")
	public List<MrErrorVO> mrErrorList(){
		
		List<MrErrorVO> list = materialService.ErrorList();
		
		return list;
	}
	
	
	
	
	
}





