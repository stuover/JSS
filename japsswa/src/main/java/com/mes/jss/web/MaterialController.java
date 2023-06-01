package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.CustomerVO;
import com.mes.jss.material.domain.AdjustmentListVO;
import com.mes.jss.material.domain.DetaiListVO;
import com.mes.jss.material.domain.MrAdjustmentVO;
import com.mes.jss.material.domain.MrErrorVO;
import com.mes.jss.material.domain.MrListVO;
import com.mes.jss.material.domain.MrOrderDetailVO;
import com.mes.jss.material.domain.MrOrderVO;
import com.mes.jss.material.domain.MrReleaseVO;
import com.mes.jss.material.domain.MrReturnVO;
import com.mes.jss.material.domain.MrVO;
import com.mes.jss.material.domain.ReturnListVO;
import com.mes.jss.material.service.MaterialService;
import com.mes.jss.production.domain.PerformanceListVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.quality.domain.QualityListVO;
import com.mes.jss.quality.domain.QualityVO;


/*
 * 구용억
 * 자재관리   마지막 수정일 (23.05.30)
 */


@Controller
@SpringBootApplication

public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	
//  자재 조회 페이지
	
	@GetMapping("/mslist")     
	public String mrList() {
			
		return "/material/material";
						
	}
	
// 자재 조회 아작스	
	
	@ResponseBody
	@GetMapping("/mslistAjax")   
	public List<MrVO> mrListAjax() {
						
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

 // 자재 재고 리스트 (총)
	
	@ResponseBody
	@GetMapping("/mrInventory")
	public List<MrVO> mrInventory(){
		
		List<MrVO> list = materialService.mrInvenList();
		
		return list;
		
	}
	
	// 반제품 재고 리스트
	
	@ResponseBody
	@GetMapping("/mrHalfInventory")
	public List<MrVO> mrHalfInventory(){
		
		
		List<MrVO> list = materialService.mrHalfInven();
		
		return list;
		
	}
	
	
	// 자재 재고 리스트
	
	@ResponseBody
	@GetMapping("/mrMatInventory")
	public List<MrVO> mrMatInventory(){
		
		List<MrVO> list = materialService.mrMatInven();
		
		return list;
		
	}
	
	
	
	// 안전 재고 리스트
	@ResponseBody
	@GetMapping("/mrCount")
	public List<MrVO> mrCount(){
		
		List<MrVO> list = materialService.mrCountList();
		
		return list;
	}
	
	// 자재 lot 재고 리스트
	@ResponseBody
	@GetMapping("/mrLotCount")
	public List<MrVO> mrLotCount(){
		
		List<MrVO> list = materialService.mrLotCountList();
		
		return list;
		
	}
	
	
 // 자재 재고 검색
	
	@ResponseBody
	@RequestMapping("/mrCountAjax")    
	public List<MrVO> mrCountSearch(@RequestParam String result){
		
		List<MrVO> list = materialService.mrCount(result);
			
		return list;
			
	}
	
	
 // 자재 검색 테스트
 @ResponseBody
 @RequestMapping("/mrSearchAjax")
 public List<MrVO> mrSearchAjax(@RequestParam String keyword, Criteria Cri){
	 
	 List<MrVO> list = materialService.mrSearchList();
	 
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

	
// 자재 입고 내역 화면
	
	@GetMapping("/mrStoreList")
	public String mrStoreList() {
		
		return "/material/materialStoreList";
	}
	
// 자재 입고 내역 리스트
	
	@ResponseBody
	@GetMapping("/StoreList")
	public List<MrVO> StoreList(){
		
		List<MrVO> list = materialService.stList();
		
		return list;
	}
	
// 자재 출고 내역 화면
	
	@GetMapping("/mrReleaseList")
	public String mrReleaseList() {
		
		return "/material/materialRelease";
	}
	

// 자재 출고 내역
	
	@ResponseBody
	@GetMapping("/mrRelList")
	public List<MrReleaseVO> mrRelList(){
		
		List<MrReleaseVO> list = materialService.mrRelGetList();
		
		return list;
	}
	
// 자재 발주 화면
	
	@GetMapping("/mrOrder")
	public String mrOrder() {   
		
		return "/material/materialOrder";
		
	}

 // 자재 발주 	
	
	@ResponseBody
	@RequestMapping("/Orders")		
	public MrOrderDetailVO orders(@RequestBody DetaiListVO vo) {
						
		materialService.orders(vo);
				
		return null;
		
	}
	
 // 자재 발주 취소
	
	@ResponseBody
	@RequestMapping("/OrderDelete")
	public MrOrderDetailVO orderDelete(@RequestBody DetaiListVO vo) {
		
		materialService.orderDel(vo);
		
		return null;
		
	}
	

// 거래처 아작스
	
	@ResponseBody
	@GetMapping("/mrCustomerAjax")     
	public List<CustomerVO> CustomerList(){
		
		List<CustomerVO> list = materialService.cusSearch();
		return list;
		
	}

// 모달창 거래처 코드로 검색	
	
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
		
		System.out.println(vo);
		
		materialService.admIn(vo);
		
		return null;
		
	}
	
	// 자재 조정 직접 등록
	
	@ResponseBody
	@RequestMapping("/mrAdmRealInsert")
	public MrAdjustmentVO mrAdmRealInsert(@RequestParam String keyword) {
		
		materialService.admRealIn(keyword);
		
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
	
	// 자재 조정 취소
	
	@ResponseBody
	@RequestMapping("/mrAdmDelete")
	public MrAdjustmentVO mrAdmDel(@RequestBody AdjustmentListVO vo) {
		
		materialService.admDel(vo);
		
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

 // 자재 반품 삭제
	@ResponseBody
	@RequestMapping("/mrReturnDelete")
	public MrReturnVO mrReturnDelete(@RequestBody ReturnListVO vo) {
		
		materialService.returnDelete(vo);
		
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





