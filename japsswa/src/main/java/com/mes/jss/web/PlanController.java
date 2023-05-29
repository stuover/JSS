package com.mes.jss.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.production.domain.PlanDatasVO;
import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.service.PlanService;
import com.mes.jss.production.service.impl.PlanServiceImpl;

import lombok.extern.log4j.Log4j2;



@Controller
@Log4j2
public class PlanController {
	

	@Autowired PlanService planService = new PlanServiceImpl();
	
	@RequestMapping("/planManage")
	public String planManagement() {
		return "production/planManage";
	}
	
	
	
	// 생산계획 조회 모달창 : 생산 계획 리스트 (초기값)
	@RequestMapping("/modalPlanListAjax")
	@ResponseBody
	public List<PlanVO> modalPlanListAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.modalPlanList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(inputData.get(0).getPlanDate()));
		log.info("inputData" + inputData);

		return inputData;
	}
	
	// 생산계획 조회 모달창 : 기간 키워드로 생산계획 검색 결과
	@RequestMapping("/modalPlanResultAjax")
	@ResponseBody
	public List<PlanVO> modalPlanResultAjax(SearchVO vo) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.modalPlanResult(vo);	
		return inputData;
	}
	
	
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 세부
	@RequestMapping("/planSearchResultAjax")
	@ResponseBody
	public List<PlanVO> planSearchResultAjax(String planId) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.planSearchResult(planId);
	
		return inputData;
	}
	
	
	
	// 제품 검색 모달창 : 완제품 리스트(초기값)
	@RequestMapping("/searchItemListAjax")
	@ResponseBody
	public List<PlanVO> searchItemListAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemList();
	
		return inputData;
	}
	
	
	// 제품명 조회 모달창 : 키워드로 완제품 검색 결과
	@RequestMapping("/searchItemResultAjax")
	@ResponseBody
	public List<PlanVO> searchItemResultAjax(PlanVO vo) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemListResult(vo);
		return inputData;
	}
	
	
	// 제품 검색 모달창 : 완제품,반제품 리스트(초기값)
	@RequestMapping("/searchItemsListAjax")
	@ResponseBody
	public List<PlanVO> searchItemsListAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemsList();
	
		return inputData;
	}
	
	
	// 제품명 조회 모달창 : 키워드로 완제품,반제품 검색 결과
	@RequestMapping("/searchItemsResultAjax")
	@ResponseBody
	public List<PlanVO> searchItemsResultAjax(PlanVO vo) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemsListResult(vo);
		return inputData;
	}
	
	

	// 생산계획 및 상세계획 등록.
	@RequestMapping("/savePlanAjax")
	@ResponseBody	
	public PlanVO savePlanAjax(@RequestBody PlanDatasVO data, Principal principal){
		System.out.println(data);
		PlanVO head =  data.getHead();
		head.setEmpNo(Long.parseLong(principal.getName()));
			
		List<PlanVO> list = data.getDetailList();
		planService.planSave(head, list);		
		return head;
	}
	
	// 생산계획 및 상세계획 수정.
		@RequestMapping("/modifyPlanAjax")
		@ResponseBody	
		public PlanVO modifyPlanAjax(@RequestBody PlanDatasVO data, Principal principal){
			System.out.println(data);
			PlanVO head =  data.getHead();
			head.setEmpNo(Long.parseLong(principal.getName()));
			
			List<PlanVO> list = data.getDetailList();
			planService.planModify(head, list);		
			return head;
		}
		
		
		// 생산계획 및 상세계획 삭제.
		@RequestMapping("/deletePlanAjax")
		@ResponseBody
		public PlanVO deletePlanAjax(@RequestBody PlanDatasVO data, Principal principal) {
			PlanVO head = data.getHead();
			
			List<PlanVO> list = data.getDetailList();
			planService.planDelete(head, list);
			return head;
		}
	
	
	
	
}
