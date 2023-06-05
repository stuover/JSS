package com.mes.jss.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mes.jss.basic.domain.EmpVO;
import com.mes.jss.basic.domain.ProcessVO;
import com.mes.jss.production.domain.PerformanceVO;
import com.mes.jss.production.domain.WorkVO;
import com.mes.jss.production.service.PerformanceService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PerformanceController {
	
	@Autowired PerformanceService performanceService;
	
	@RequestMapping("/performanceManage")
	public String performanceMangement() {
		
		return "production/performanceManage";
	}
	
	
	// 공정 조회 모달창 : 공정 리스트(초기값)
	@RequestMapping("/searchProcessModalAjax")
	@ResponseBody
	public List<ProcessVO> searchProcessModalAjax (){
		List<ProcessVO> result = new ArrayList<>();
		result = performanceService.processList();
		
		return result;
	}
	
	// 공정 조회 모달창 : 공정 리스트(키워드 검색 결과)
	@RequestMapping("/searchProcessModalResultAjax")
	@ResponseBody
	public List<ProcessVO> searchProcessModalResultAjax(ProcessVO vo){
		List<ProcessVO> result = performanceService.processListResult(vo);
		
		return result;
	}
	
	// 작업지시 조회 모달창 : 작업지시 내역
	// 작업이 완료된 작업지시 제외
	// 작업 시작 시간이 현재 날짜인 것만 조회
	@RequestMapping("/searchWorkModalAjax")
	@ResponseBody
	public List<WorkVO> searchWorkModalAjax(){
		List<WorkVO> result = performanceService.todayWorkModalList();
		
		return result;
	}
	
	
	
	// 생산실적 등록 모달창 : 사원 리스트
	@RequestMapping("/workerListAjax")
	@ResponseBody
	public List<EmpVO> workerListAjax(){
		List<EmpVO> result = performanceService.empList();
		
		return result;
	}
	
	
	// 생산실적 등록 모달창 :  설비 리스트
	// 설비 조회 모달창 : 비가동 사유가 점검이나 세척이 아닌 설비 리스트
	@RequestMapping("/performanceFacListAjax")
	@ResponseBody
	public List<PerformanceVO> performanceFacListAjax(String proCode){
		List<PerformanceVO> result = performanceService.performanceFacList(proCode);
		
		return result;
	}
	
	// 생산실적 등록 : 작업 시작
	@RequestMapping("/performanceStartAjax")
	@ResponseBody
	public void performanceStartAjax(PerformanceVO vo) {
		performanceService.performanceStart(vo);
	}
	
	
	// 생산실적 등록 : 작업 완료
	@RequestMapping("/performanceEndAjax")
	@ResponseBody
	public void performanceEndAjax(PerformanceVO vo) {
		performanceService.performanceStart(vo);
	}
	
	
}
