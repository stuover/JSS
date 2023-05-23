package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.domain.SearchVO;

public interface PlanMapper {
	
	// 생산계획 조회 모달창 : 생산 계획 리스트(초기값) 
	List<PlanVO> modalPlanList();
	
	// 생산계획 조회 모달창 : 기간 키워드로 생산계획 검색 결과
	List<PlanVO> modalPlanResult(SearchVO vo);
	
	
	// 생산계획관리 페이지 : 생산 계획 세부내용 검색 결과
	List<PlanVO> planSearchResult(String id);
	
	
	
	// 제품 검색 모달창 : 제품 리스트(초기값)
	List<PlanVO> itemList();
	
	// 제품 검색 모달창 : 제품 리스트(검색결과)
	List<PlanVO> itemListResult(PlanVO vo);
	
	
	// 생산계획 등록.
	// 생산계획 공통 내용
	public PlanVO planSave(PlanVO vo);
	// 생산계획 세부 내용
	public PlanVO planDetailSave(PlanVO vo);
	
	
	// 생산계획 수정.
	// 생산계획 공통 내용
	public int planModify(PlanVO vo);	
	// 생산계획 세부 내용
	public int planDetailModify(PlanVO vo);
	
	
	
	// 생산계획 삭제.
	// 생산계획 공통 내용.
	int planDelete(PlanVO vo);
	
	// 생산계획 세부 내용.
	int planDetailDelete(PlanVO vo);
	
	
	
}
