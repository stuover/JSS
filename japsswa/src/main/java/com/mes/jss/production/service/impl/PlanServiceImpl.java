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
	
	// 조회 모달창 초기 데이터
	@Override
	public List<PlanVO> modalPlanList() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.modalPlanList();
		return list;
	}
	
	// 조회 모달창 검색 결과
	@Override
	public List<PlanVO> modalPlanResult(SearchVO vo) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.modalPlanResult(vo);
		
		return list;
	}
	
	// 조회 모달창에서 선택한 생산 계획 내용
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
		//계획헤더
		planMapper.planSave(vo);
		 
		//계획세부사항
		for(PlanVO planVO : list) {
			 planVO.setPlanCode(vo.getPlanCode());
			 planMapper.planDetailSave(planVO);
		}
	}

	// 제품 검색 모달창 : 제품 리스트(
	@Override
	public List<PlanVO> itemList(PlanVO vo) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.itemList(vo);
		return list;
	}







}
