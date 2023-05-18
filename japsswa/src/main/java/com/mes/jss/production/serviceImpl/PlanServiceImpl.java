package com.mes.jss.production.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mes.jss.production.PlanVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired PlanMapper planMapper;
	
	@Override
	public List<PlanVO> planOrderInfo() {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.planOrderInfo();
		
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
	public PlanVO commonSearchResult(PlanVO vo) {
		PlanVO result = new PlanVO();
		result = planMapper.commonSearchResult(vo);
		return result;
	}

	@Override
	public List<PlanVO> detailSearchResult(PlanVO vo) {
		List<PlanVO> list = new ArrayList<>();
		list = planMapper.detailSearchResult(vo);
		return list;
	}



}
