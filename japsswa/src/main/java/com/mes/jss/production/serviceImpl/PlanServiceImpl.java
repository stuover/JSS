package com.mes.jss.production.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mes.jss.production.PlanVO;
import com.mes.jss.production.mapper.PlanMapper;
import com.mes.jss.production.service.PlanService;

public class PlanServiceImpl implements PlanService {

	@Autowired PlanMapper planMapper;
	
	@Override
	public List<PlanVO> planOrderInfo() {
		List<PlanVO> list = new ArrayList<>();
		
		
		return list;
	}

}
