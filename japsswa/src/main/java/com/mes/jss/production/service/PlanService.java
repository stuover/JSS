package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.domain.SearchVO;

public interface PlanService {
	
	// 생산계획 조회 모달창 : 생산 계획 리스트(초기값)
	List<PlanVO> modalPlanList();
	
	// 생산계획 조회 모달창 : 기간 키워드로 생산계획 검색 결과
	List<PlanVO> modalPlanResult(SearchVO vo);
	
	
	
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 세부
	List<PlanVO> planSearchResult(String id);
	
	
	
	// 제품 검색 모달창 : 제품 리스트(초기값)
	List<PlanVO> itemList();
	
	// 제품 검색 모달창 : 제품 리스트(검색결과)
	List<PlanVO> itemListResult(PlanVO vo);	
	
	
	
	// 생산계획 등록.
	public void planSave(PlanVO head, List<PlanVO> detail); 
	
	// 생산계획 수정.
	public void planModify(PlanVO head, List<PlanVO> detail);
	
	
}
