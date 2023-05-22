package com.mes.jss.web;

import java.security.Principal;
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
public class ProductionController {
	

	@Autowired PlanService planService = new PlanServiceImpl();
	
	@RequestMapping("/planManage")
	public String planManagement() {
		return "production/planManage";
	}
	
	// 생산계획 조회 모달창 : 생산 계획 리스트(초기값)
	@RequestMapping("/modalPlanListAjax")
	@ResponseBody
	public List<PlanVO> modalPlanListAjax() {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.modalPlanList();
		log.info("inputData" + inputData);

		return inputData;
	}
	
	// 기간 키워드로 생산계획 검색 결과
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
	
	// 제품명 키워드로 검색 결과
	@RequestMapping("/searchItemListAjax")
	@ResponseBody
	public List<PlanVO> searchItemListAjax(PlanVO vo) {
		List<PlanVO> inputData = new ArrayList<>();
		inputData = planService.itemList(vo);
	
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
	
	
	
	
	
}
