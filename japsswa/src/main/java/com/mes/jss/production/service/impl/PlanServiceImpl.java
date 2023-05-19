package com.mes.jss.production.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.production.domain.PlanVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired PlanMapper planMapper;
	
	@Override
	public List<PlanVO> itemListInfo() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.itemListInfo();
		
		return list;
	}

	@Override
	public List<PlanVO> modalPlanList() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.modalPlanList();
		
		return list;
	}



	@Override
	public PlanVO planSave(PlanVO vo) {
		
		return planMapper.planSave(vo);
	}


	@Override
	public List<PlanVO> planSearchResult(String id) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.planSearchResult(id);
		return list;
	}



}
