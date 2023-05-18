package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.production.PlanVO;

public interface PlanService {
	
	// 생산계획관리 페이지 : 초기 정보
	List<PlanVO> planOrderInfo();

	List<PlanVO> modalPlanList();
	
	public PlanVO planSave(PlanVO vo); 
	
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 공통
	public PlanVO commonSearchResult(PlanVO vo);
		
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 세부
	List<PlanVO> detailSearchResult(PlanVO vo);	
	
	
	
}
