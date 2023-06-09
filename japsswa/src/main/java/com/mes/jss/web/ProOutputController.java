package com.mes.jss.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.service.PerformanceService;
import com.mes.jss.production.service.WorkService;

@Controller
public class ProOutputController {
	
	@Autowired WorkService workService;
	@Autowired PerformanceService performanceservice;

	@RequestMapping("/proOutput")
	public String proOutput(){
		return "production/processOutput";
	}
	
	@RequestMapping("/monitoring")
	public String monitoring(){
		return "production/monitoring";
	}
	
	@RequestMapping("/performanceChart")
	public String performanceChart() {
		return "production/performanceChart";
	}
	
	
	// 공정이동표 조회 페이지
	// 작업지시 조회 모달 : 초기값
	@RequestMapping("/proMoveWorkModalListAjax")
	@ResponseBody
	public List<WorkVO> proMoveWorkModalListAjax(){
		List<WorkVO> data = workService.proMoveWorkModalList();
		
		return data;
	}
	// 작업지시 조회 모달 : 결과값
	@RequestMapping("/proMoveWorkModalResultAjax")
	@ResponseBody
	public List<WorkVO> proMoveWorkModalResultAjax(SearchVO vo){
		List<WorkVO> data = workService.proMoveWorkModalResult(vo);
		
		return data;
	}
	
	// 작업지시 상세 더블클릭 -> 해당 작업지시상세에 해당하는 공정현황 조회 
	@RequestMapping("/processCurrInfoAjax")
	@ResponseBody
	public List<WorkVO> processCurrInfoAjax(WorkVO vo){
		List<WorkVO> data = workService.processCurrInfo(vo);
		
		return data;
	}
	
	// 생산 실적 차트
	@RequestMapping("/todayOutputChartAjax")
	@ResponseBody
	public List<PerformanceVO> todayOutputChart(){
		List<PerformanceVO> data = performanceservice.todayChart();
		
		return data;
	}
	
}
