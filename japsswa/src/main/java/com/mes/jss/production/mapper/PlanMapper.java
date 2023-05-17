package com.mes.jss.production.mapper;

import java.util.List;

import com.mes.jss.production.PlanVO;

public interface PlanMapper {

	List<PlanVO> planOrderInfo();
	List<PlanVO> modalPlanList();
	List<PlanVO> pdetailSearchResult(String id);
}
