package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.domain.SearchVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired PlanMapper planMapper;
	
	// 생산계획 조회 모달창 : 생산 계획 리스트(초기값)
	@Override
	public List<PlanVO> modalPlanList() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.modalPlanList();
		return list;
	}
	
	// 생산계획 조회 모달창 : 기간 키워드로 생산계획 검색 결과
	@Override
	public List<PlanVO> modalPlanResult(SearchVO vo) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.modalPlanResult(vo);
		
		return list;
	}
	
	// 생산계획관리 페이지 : 검색해서 찾은 생산 계획 세부
	@Override
	public List<PlanVO> planSearchResult(String id) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.planSearchResult(id);
		return list;
	}

	
	
	
	// 생산 계획 등록.
	@Override
	@Transactional
	public void planSave(PlanVO vo, List<PlanVO> list) {
		//계획 헤더
		planMapper.planSave(vo);
		 
		//계획 세부사항
		for(PlanVO planVO : list) {
			 planVO.setPlanCode(vo.getPlanCode());
			 planMapper.planDetailSave(planVO);
		}
	}

	
	
	// 제품 검색 모달창 : 제품 리스트(초기값)	
	@Override
	public List<PlanVO> itemList() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.itemList();
		return list;
	}
	
	
	// 제품 검색 모달창 : 제품 리스트(검색결과)
	@Override
	public List<PlanVO> itemListResult(PlanVO vo) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.itemListResult(vo);
		return list;
	}
	
	
	// 생산 계획 수정.
	@Override
	@Transactional
	public void planModify(PlanVO vo, List<PlanVO> list) {
		//계획 헤더
		planMapper.planModify(vo);
		 
		//계획 세부사항
		for(PlanVO planVO : list) {
			 planVO.setPlanCode(vo.getPlanCode());
			 planMapper.planDetailModify(planVO);
		}
		
	}







}
