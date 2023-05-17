package com.mes.jss.production.service;

import java.util.List;

import com.mes.jss.production.PlanVO;

public interface PlanService {
	List<PlanVO> planOrderInfo();
	List<PlanVO> modalPlanList();
}
