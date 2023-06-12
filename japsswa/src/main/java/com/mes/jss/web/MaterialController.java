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
 * 자재관리   마지막 수정일 (23.06.08)
 */


@Controller
@SpringBootApplication

public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	
//  자재 조회 페이지
	
	@GetMapping("/mslist")     
	public String mrList() {
			
		return "material/material";
						
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
	
// 자재 입고내역 검색(동적쿼리)
	
	@ResponseBody
	@RequestMapping("/searchQuery")
	public List<MrVO> mrStoreListQuery(@RequestBody MrVO vo){
		System.err.println(vo);
		List<MrVO> list = materialService.mrStoreListQuery(vo);		
		
		
		
		return list;
		
	}
	
// 자재 입고확인 검색
	
	@ResponseBody
	@RequestMapping("/mrStoreListQuery")
	public List<MrVO> mrStoreQueryList(@RequestBody MrVO vo){
		
		List<MrVO> list = materialService.mrStoreQuery(vo);
		
		return list;
	}
	
	
	
 // 자재 검색(동적쿼리)
	
	@ResponseBody
	@RequestMapping("/multi")
	public List<MrVO> mrMultiSearch(MrVO vo){
		
		System.err.println(vo);
		
		List<MrVO> list = materialService.MultiSearchList(vo);
		return list;
		
	}
	

 // 자재 재고 리스트 (총)
	
	@ResponseBody
	@GetMapping("/mrInventory")
	public List<MrVO> mrInventory(){
		
		List<MrVO> list = materialService.mrInvenList();
		
		return list;
		
	}
	
 // 자재 재고 lot 조회
	
	@ResponseBody
	@RequestMapping("/mrLotList")
	public List<MrVO> mrLotList(@RequestParam String itemName){
		
		List<MrVO> list = materialService.mrLot(itemName);
		
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
	
	
	// 입고 사유별 리스트(품질)
	
	@ResponseBody
	@GetMapping("/qualityReason")
	public List<MrVO> materialQualityReason(){
		
		List<MrVO> list = materialService.mrQualityList();
		
		return list;
		
	}
	
	// 입고 사유별 리스트(생산)
	
		@ResponseBody
		@GetMapping("/productReason")
		public List<MrVO> materialProReason(){
			
			List<MrVO> list = materialService.mrProList();
			
			return list;
			
		}
		
	// 입고 사유별 리스트(조정)
		
	@ResponseBody
	@GetMapping("/AdjustmentReason")
		public List<MrVO> materialAdmReason(){
				
			List<MrVO> list = materialService.mrAdmReasonList();
				
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
		
		return "material/materialStoreList";
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
		
		return "material/materialRelease";
	}
	

// 자재 출고 내역
	
	@ResponseBody
	@GetMapping("/mrRelList")
	public List<MrReleaseVO> mrRelList(){
		
		List<MrReleaseVO> list = materialService.mrRelGetList();
		
		return list;
	}
	
 // 자재 출고 내역 검색
	
	@ResponseBody
	@RequestMapping("/mrReleaseSearch")
	public List<MrReleaseVO> mrReleaseSearch(@RequestBody MrReleaseVO vo){
		
		System.err.println(vo);
		
		List<MrReleaseVO> list = materialService.mrRelSearch(vo);
		
		return list;
		
	}
	
	
	
	// 출고 사유별 리스트(생산)
	
    @ResponseBody
	@GetMapping("/RelProReason")
	public List<MrVO> mrRelProReason(){
			
		List<MrVO> list = materialService.mrRelProList();
			
		return list;
			
		}
		
	// 출고 사유별 리스트(조정)
		
	@ResponseBody
	@GetMapping("/RelAdmReason")
	public List<MrVO> mrRelAdmReason(){
				
		List<MrVO> list = materialService.mrRelAdmList();
				
		return list;
				
			}
			
	
	
	
	
// 자재 발주 화면
	
	@GetMapping("/mrOrder")
	public String mrOrder() {   
		
		return "material/materialOrder";
		
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
	
 // 자재 발주 조회용
	
	@ResponseBody
	@RequestMapping("/OrderList")
	public List<MrOrderDetailVO> orderList() {
		
		List<MrOrderDetailVO> list = materialService.orderList();
		
		return list;
		
	}
	
	
 // 자재 발주 스케줄러
	
	
	@GetMapping("/OrderCalendar")
	public String OrderCalendar() {
		
		return "material/materialOrderCalendar";
		
	}
	
 // 발주 거래처 자재 검색
	
	@ResponseBody
	@RequestMapping("/CusMrList")
	public List<CustomerVO> cusMrSearchList(CustomerVO vo){
		
		List<CustomerVO> list = materialService.cusListQuery(vo);
		
		return list;
		
	}
	
 // 발주 조회용 리스트 검색
	
	@ResponseBody
	@RequestMapping("/orderBeforeSearch")
	public List<MrOrderVO> orderBeforeSearch(@RequestBody MrOrderVO vo){
		
		System.err.println(vo);
		
		List<MrOrderVO> list = materialService.orderBeforeQuery(vo);
		
		return list;
		
	}
	
	//발주 내역 검색
	
	@ResponseBody
	@RequestMapping("/ordersQuerySearch")
	public List<MrOrderVO> ordersQuerySearch(@RequestBody MrOrderVO vo){
		
		System.err.println(vo);
		List<MrOrderVO> list = materialService.ordersQuery(vo);
		
		return list;
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
		
		
		return "material/materialOrderList";
		
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
		
		return "material/materialAdjustment";
		
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

 // 자재 조정 하기위해 출고, 입고 버튼 클릭하기 위해 입고 수량, 출고 수량 가져오기
	
	@ResponseBody
	@RequestMapping("/mrAdmInRel")
	public List<MrAdjustmentVO> admInRel(@RequestBody MrAdjustmentVO vo){
		
		List<MrAdjustmentVO> list = materialService.admInRel(vo);
		
		return list;
	}
	
 // 자재 lot별 조정 조회
	
	@ResponseBody
	@GetMapping("/mrAdmSearchAjax")
	public List<MrAdjustmentVO> admSearchList(){
		
		List<MrAdjustmentVO> list = materialService.admSearchList();
		
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
	public MrAdjustmentVO mrAdmRealInsert(@RequestBody AdjustmentListVO vo) {
		
		materialService.admRealIn(vo);
		
		return null;
		
	}
	
	// 자재 조정 lot 검색
	
	@ResponseBody
	@RequestMapping("/mrAdmLotSearch")
	public List<MrAdjustmentVO> mrAdmLotSearch(@RequestBody MrAdjustmentVO vo) {
		
		List<MrAdjustmentVO> list = materialService.mrLotSearch(vo);
		
		return list;
		
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
	
	// 자재 조정 수량 조정
	
	@ResponseBody
	@RequestMapping("/mrAdmCount")
	public MrAdjustmentVO mrAdmCount(@RequestBody AdjustmentListVO vo) {
		
		System.err.println(vo);
		
		materialService.admCount(vo);
		
		return null;
		
	}
	
	//자재 조정 리스트 화면
	@GetMapping("/mrAdmDisplay")
	public String mrAdmListDisplay() {
		
		return "material/materialAdjustmentList";
	}
	
	// 자재 조정 내역 리스트
	
	@ResponseBody
	@RequestMapping("/mrAdmFullList")
	public List<MrAdjustmentVO> mrAdmFullList(){
		
		List<MrAdjustmentVO> list = materialService.mrAdmFullList();
		
		return list;
		
	}
	
	// 자재 조정 검색
	
	@ResponseBody
	@RequestMapping("/mrAdmSearch")
	public List<MrAdjustmentVO> mrAdmQuery(@RequestBody MrAdjustmentVO vo){
		
		System.out.println(vo);
		
		List<MrAdjustmentVO> list = materialService.mrAdmSearch(vo);
		
		return list;
		
	}
	
	
	
// 자재 반품 화면
	
	@GetMapping("/mrReturn")
	public String mrReturn() {
		
		return "material/materialReturn";
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
	
// 자재 반품 내역 화면
	
	@GetMapping("/mrReturnList")
	public String mrReturnListDisplay() {
		
		
		
		return "material/materialReturnList";
	}
	
 // 반품 검색
	
	@ResponseBody
	@RequestMapping("/mrReturnSearch")
	public List<MrReturnVO> mrReturnSearch(@RequestBody MrReturnVO vo) {
		
		System.err.println(vo);	
		
		List<MrReturnVO> list = materialService.mrReturnSearch(vo);
		
		return list;
		
	}
	
	
	
	
	
 //  자재 불량 화면
	
	@GetMapping("/mrError")
	public String mrError() {
		
		return "material/materialError";
	}
	
	
 // 자재 불량 리스트
	
	@ResponseBody
	@GetMapping("/mrErrorAjax")
	public List<MrErrorVO> mrErrorList(){
		
		List<MrErrorVO> list = materialService.ErrorList();
		
		return list;
	}
	
  
	// 
	
	
	
}





