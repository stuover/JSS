package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.domain.SearchVO;

public interface PlanMapper {
	
	// 생산계획 조회 모달창 : 생산 계획 리스트(초기값) 
	List<PlanVO> modalPlanList();
	
	// 기간 키워드로 생산계획 검색 결과
	List<PlanVO> modalPlanResult(SearchVO vo);
	
	// 제품 검색 모달창 : 제품 리스트(검색결과)
	List<PlanVO> itemList(PlanVO vo);
	
	
	// 생산계획 및 상세계획 등록.
	public PlanVO planSave(PlanVO vo);
	
	public PlanVO planDetailSave(PlanVO vo);
	
	
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 세부
	List<PlanVO> planSearchResult(String id);
	
	
}
